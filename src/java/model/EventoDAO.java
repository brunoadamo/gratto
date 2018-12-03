package model;

/**
 *
 * @author MaickHenriquePereira
 */
import service.BD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    public Evento evento;
    public BD bd;

    public EventoDAO() {
        bd = new BD();
        evento = new Evento();
    }

    /**
     * Grava uma instituicao na Base de Dados
     *
     * @param instituicao instituicao recebe um objeto do tipo instituicao
     * @return retorna
     */
    public boolean gravar(Instituicao instituicao) {

        String sql = "INSERT INTO Instituicao(Razao_Social,Nome_Fantasia,CNPJ,Endereco,Numero,Bairro,	Cidade,	Estado,	Pais,CEP,Telefone,Email,Site,Facebook,Status,Ativo,Responsavel,Categoria,descricao,img) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            bd.getConnection();

            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, instituicao.getRazaoSocial());
            bd.st.setString(2, instituicao.getNomeFantasia());
            bd.st.setString(3, instituicao.getCnpj());
            bd.st.setString(4, instituicao.getEnderecoInstituicao());
            bd.st.setString(5, instituicao.getNumero());
            bd.st.setString(6, instituicao.getBairro());
            bd.st.setString(7, instituicao.getCidadeInstituicao());
            bd.st.setString(8, instituicao.getEstadoInstituicao());
            bd.st.setString(9, instituicao.getPaisInstituicao());
            bd.st.setString(10, instituicao.getCepInstituicao());
            bd.st.setString(11, instituicao.getTelefoneInstituicao());
            bd.st.setString(12, instituicao.getEmailInstituicao());
            bd.st.setString(13, instituicao.getSiteInstituicao());
            bd.st.setString(14, instituicao.getFacebookInstituicao());
            bd.st.setString(16, instituicao.getStatusInstituicao());

            int n = bd.st.executeUpdate();
            return true;

        } catch (SQLException erro) {
            System.out.println(erro.toString());
            return false;
        }
    }

    /**
     * Exclu� uma Instituicao
     *
     * @param codigo recebe o c�digo da Instituicao que ser� exclu�da
     * @return Retorna a mensagem com o status da opera��o
     */
    public boolean excluir(int codigo) {

        String sql = "DELETE FROM evento where Codigo = ?;";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigo);
            int n = bd.st.executeUpdate();

        } catch (SQLException erro) {
            return false;

        } finally {
            bd.close();
        }

        return true;
    }

    /**
     * ALtera uma Instituicao
     *
     * @param instituicao recebe um objeto do tipo Instituicao
     * @return retorna uma mensagem de acordo com as regras definidas
     */
    public boolean atualizar(Instituicao instituicao) {

        String sql = "UPDATE evento SET Razao_Social = ?, Nome_Fantasia = ?, cnpj = ?, Endereco = ?, Numero = ?, Bairro = ?, Cidade = ?, Estado = ?, Pais = ?, cep = ?, Telefone = ?, Email = ?, Site = ?, Facebook = ?, Descricao = ? " + " WHERE Codigo = ?;";

        try {
            bd.getConnection();

            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, instituicao.getRazaoSocial());
            bd.st.setString(2, instituicao.getNomeFantasia());
            bd.st.setString(3, instituicao.getCnpj());
            bd.st.setString(4, instituicao.getEnderecoInstituicao());
            bd.st.setString(5, instituicao.getNumero());
            bd.st.setString(6, instituicao.getBairro());
            bd.st.setString(7, instituicao.getCidadeInstituicao());
            bd.st.setString(8, instituicao.getEstadoInstituicao());
            bd.st.setString(9, instituicao.getPaisInstituicao());
            bd.st.setString(10, instituicao.getCepInstituicao());
            bd.st.setString(11, instituicao.getTelefoneInstituicao());
            bd.st.setString(12, instituicao.getEmailInstituicao());
            bd.st.setString(13, instituicao.getSiteInstituicao());
            bd.st.setString(14, instituicao.getFacebookInstituicao());
            bd.st.setString(15, instituicao.getDescricao());
            bd.st.setInt(16, instituicao.getIdInstituicao());

            int n = bd.st.executeUpdate();

            return true;

        } catch (SQLException erro) {
            System.out.println(erro.toString());
            return false;

        }
    }

    /**
     * Localiza uma Instituicao utilizando o c�digo
     *
     * @param codigo codigo da Instituicao a ser buscada
     * @return retorna a Instituicao preenchida
     */
    public Evento localizar(int codigo) {

        Evento i = new Evento();
        String sql = "SELECT * FROM evento WHERE codigo = ?";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigo);

            bd.rs = bd.st.executeQuery();
            if (bd.rs.next()) {

                i.setIdEvento(bd.rs.getInt("Codigo"));
                i.setNome(bd.rs.getString("Nome"));
                i.setDesc(bd.rs.getString("Descricao"));
                i.setDataIni(bd.rs.getString("Data_Inicio"));
                i.setDataFim(bd.rs.getString("Data_Fim"));
                i.setHoraIni(bd.rs.getString("Hora_Inicio"));
                i.setHoraFim(bd.rs.getString("Hora_Fim"));
                i.setAtivo(bd.rs.getInt("Ativo"));
                i.setLimit(bd.rs.getInt("Limite_Participantes"));
                i.setCod_inst(bd.rs.getInt("Cod_Inst"));
                return i;
            } else {
                return null;
            }

        } catch (SQLException erro) {
            System.out.println(erro.toString());
            return null;

        } finally {
            bd.close();
        }
    }

    public List<Instituicao> relatorio(String codigo) {

        List<Instituicao> list = new ArrayList<Instituicao>();

        String sql = "SELECT SUM(valor) as doacoes, month(data) as mes_doacao FROM doacao WHERE Cod_Inst = " + codigo + " group by month(data);";

        System.out.println(sql);

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Instituicao i = new Instituicao();

                i.setIdInstituicao(bd.rs.getInt("doacoes"));
                i.setImg(bd.rs.getInt("mes_doacao"));
                //bd.st.setBoolean(17, instituicao.instIsActive());
                list.add(i);

            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    /**
     * Localiza uma Instituicao utilizando o nome Fantasia da Instituicao
     *
     * @param nomeFantasia
     * @param estado
     * @param codigo codigo da Instituicao a ser buscada
     * @return retorna a Instituicao preenchida
     */
    public List<Evento> localizar(String nomeFantasia, String estado) {

        List<Evento> list = new ArrayList<Evento>();

        String where = "";
        try {
            if (!estado.isEmpty()) {
                where = " AND estado = '" + estado + "'";
            }
        } catch (Exception e) {
        }

        String sql = "SELECT * FROM Instituicao WHERE Nome_Fantasia LIKE '%" + nomeFantasia + "%'" + where;

        System.out.println(sql);

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Evento i = new Evento();

                i.setIdEvento(bd.rs.getInt("Codigo"));
                i.setNome(bd.rs.getString("Nome"));
                i.setDesc(bd.rs.getString("Descricao"));
                i.setDataIni(bd.rs.getString("Data_Inicio"));
                i.setDataFim(bd.rs.getString("Data_Fim"));
                i.setHoraIni(bd.rs.getString("Hora_Inicio"));
                i.setHoraFim(bd.rs.getString("Hora_Fim"));
                i.setAtivo(bd.rs.getInt("Ativo"));
                i.setLimit(bd.rs.getInt("Limite_Participantes"));
                i.setCod_inst(bd.rs.getInt("Cod_Inst"));
                list.add(i);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public List<Evento> listaInst(int codigo) {

        List<Evento> list = new java.util.ArrayList<Evento>();

        String sql = "SELECT * FROM evento WHERE Cod_Inst = '" + codigo + "'";
        System.out.println(sql);

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Evento i = new Evento();
                i.setIdEvento(bd.rs.getInt("Codigo"));
                i.setNome(bd.rs.getString("Nome"));
                i.setDesc(bd.rs.getString("Descricao"));
                i.setDataIni(bd.rs.getString("Data_Inicio"));
                i.setDataFim(bd.rs.getString("Data_Fim"));
                i.setHoraIni(bd.rs.getString("Hora_Inicio"));
                i.setHoraFim(bd.rs.getString("Hora_Fim"));
                i.setAtivo(bd.rs.getInt("Ativo"));
                i.setLimit(bd.rs.getInt("Limite_Participantes"));
                i.setCod_inst(bd.rs.getInt("Cod_Inst"));

                list.add(i);

            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public List<Evento> listaTodos() {

        List<Evento> list = new java.util.ArrayList<Evento>();

        String sql = "SELECT * FROM evento";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Evento param = new Evento();
                bd.st.setInt(1, param.getIdEvento());
                bd.st.setString(2, param.getNome());
                bd.st.setString(3, param.getDesc());
                bd.st.setString(4, param.getDataIni());
                bd.st.setString(5, param.getDataFim());
                bd.st.setString(6, param.getHoraIni());
                bd.st.setString(7, param.getHoraFim());
                bd.st.setInt(8, param.getLimit());
                list.add(param);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public List<Evento> listaCod(String codigo) {

        List<Evento> list = new ArrayList<Evento>();

        String sql = "SELECT * FROM evento WHERE cod_usuario = '" + codigo + "'";
        System.out.println(sql);

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Evento i = new Evento();

                i.setIdEvento(bd.rs.getInt("Codigo"));
                i.setNome(bd.rs.getString("Nome"));
                i.setDesc(bd.rs.getString("Descricao"));
                i.setDataIni(bd.rs.getString("Data_Inicio"));
                i.setDataFim(bd.rs.getString("Data_Fim"));
                i.setHoraIni(bd.rs.getString("Hora_Inicio"));
                i.setHoraFim(bd.rs.getString("Hora_Fim"));
                i.setAtivo(bd.rs.getInt("Ativo"));
                i.setLimit(bd.rs.getInt("Limite_Participantes"));
                i.setCod_inst(bd.rs.getInt("Cod_Inst"));
                list.add(i);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public List<Evento> listaParticipacao(String codigo) {

        List<Evento> list = new ArrayList<Evento>();

        String sql = "SELECT participacao.Codigo, Nome, Descricao, Data_inicio,Hora_inicio FROM evento, participacao where participacao.cod_usuario = '" + codigo + "' AND participacao.cod_evento = evento.codigo";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Evento i = new Evento();

                i.setIdEvento(bd.rs.getInt("Codigo"));
                i.setNome(bd.rs.getString("Nome"));
                i.setDesc(bd.rs.getString("Descricao"));
                i.setDataIni(bd.rs.getString("Data_Inicio"));
                i.setHoraIni(bd.rs.getString("Hora_Inicio"));
                list.add(i);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public String localizaNome(String codigo) {

        List<Instituicao> list = new ArrayList<Instituicao>();

        String sql = "SELECT nome_fantasia FROM instituicao WHERE codigo = '" + codigo + "'";

        String nome_fantasia = "";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            if (bd.rs.next()) {
                nome_fantasia = bd.rs.getString("Nome_Fantasia");
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return nome_fantasia;
    }
}
