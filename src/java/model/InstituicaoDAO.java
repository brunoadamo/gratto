package model;

/**
 *
 * @author MaickHenriquePereira
 */
import service.BD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstituicaoDAO {

    public Instituicao instituicao;
    public BD bd;

    public InstituicaoDAO() {
        bd = new BD();
        instituicao = new Instituicao();
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

        String sql = "DELETE FROM Instituicao where Codigo = ?;";

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

        String sql = "UPDATE Instituicao SET Razao_Social = ?, Nome_Fantasia = ?, cnpj = ?, Endereco = ?, Numero = ?, Bairro = ?, Cidade = ?, Estado = ?, Pais = ?, cep = ?, Telefone = ?, Email = ?, Site = ?, Facebook = ?, Descricao = ? " + " WHERE Codigo = ?;";

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
    public Instituicao localizar(int codigo) {

        Instituicao i = new Instituicao();
        String sql = "SELECT * FROM Instituicao WHERE codigo = ?";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigo);

            bd.rs = bd.st.executeQuery();
            if (bd.rs.next()) {

                i.setIdInstituicao(bd.rs.getInt("Codigo"));
                i.setRazaoSocial(bd.rs.getString("Razao_Social"));
                i.setDescricao(bd.rs.getString("descricao"));
                i.setNomeFantasia(bd.rs.getString("Nome_Fantasia"));
                i.setCnpj(bd.rs.getString("CNPJ"));
                i.setEnderecoInstituicao(bd.rs.getString("Endereco"));
                i.setNumero(bd.rs.getString("Numero"));
                i.setBairro(bd.rs.getString("Bairro"));
                i.setCidadeInstituicao(bd.rs.getString("Cidade"));
                i.setEstadoInstituicao(bd.rs.getString("Estado"));
                i.setPaisInstituicao(bd.rs.getString("Pais"));
                i.setCepInstituicao(bd.rs.getString("CEP"));
                i.setTelefoneInstituicao(bd.rs.getString("Telefone"));
                i.setEmailInstituicao(bd.rs.getString("Email"));
                i.setSiteInstituicao(bd.rs.getString("Site"));
                i.setFacebookInstituicao(bd.rs.getString("Facebook"));
                i.setDataAprovacao(bd.rs.getString("Data_Aprovacao"));
                i.setStatusInstituicao(bd.rs.getString("Status"));
                i.setImg(bd.rs.getInt("img"));
                //bd.st.setBoolean(17, instituicao.instIsActive());
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
    public List<Instituicao> localizar(String nomeFantasia, String estado) {

        List<Instituicao> list = new ArrayList<Instituicao>();

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
                Instituicao i = new Instituicao();

                i.setIdInstituicao(bd.rs.getInt("Codigo"));
                i.setRazaoSocial(bd.rs.getString("Razao_Social"));
                i.setNomeFantasia(bd.rs.getString("Nome_Fantasia"));
                i.setDescricao(bd.rs.getString("descricao"));
                i.setCnpj(bd.rs.getString("CNPJ"));
                i.setEnderecoInstituicao(bd.rs.getString("Endereco"));
                i.setNumero(bd.rs.getString("Numero"));
                i.setBairro(bd.rs.getString("Bairro"));
                i.setCidadeInstituicao(bd.rs.getString("Cidade"));
                i.setEstadoInstituicao(bd.rs.getString("Estado"));
                i.setPaisInstituicao(bd.rs.getString("Pais"));
                i.setCepInstituicao(bd.rs.getString("CEP"));
                i.setTelefoneInstituicao(bd.rs.getString("Telefone"));
                i.setEmailInstituicao(bd.rs.getString("Email"));
                i.setSiteInstituicao(bd.rs.getString("Site"));
                i.setFacebookInstituicao(bd.rs.getString("Facebook"));
                i.setDataAprovacao(bd.rs.getString("Data_Aprovacao"));
                i.setStatusInstituicao(bd.rs.getString("Status"));
                i.setImg(bd.rs.getInt("img"));
                list.add(i);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public List<Instituicao> listaTodos() {

        List<Instituicao> list = new ArrayList<Instituicao>();

        String sql = "SELECT * FROM instituicao";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Instituicao i = new Instituicao();
                i.setIdInstituicao(bd.rs.getInt("Codigo"));
                i.setRazaoSocial(bd.rs.getString("Razao_Social"));
                i.setNomeFantasia(bd.rs.getString("Nome_Fantasia"));
                i.setDescricao(bd.rs.getString("descricao"));
                i.setCnpj(bd.rs.getString("CNPJ"));
                i.setEnderecoInstituicao(bd.rs.getString("Endereco"));
                i.setNumero(bd.rs.getString("Numero"));
                i.setBairro(bd.rs.getString("Bairro"));
                i.setCidadeInstituicao(bd.rs.getString("Cidade"));
                i.setEstadoInstituicao(bd.rs.getString("Estado"));
                i.setPaisInstituicao(bd.rs.getString("Pais"));
                i.setCepInstituicao(bd.rs.getString("CEP"));
                i.setTelefoneInstituicao(bd.rs.getString("Telefone"));
                i.setEmailInstituicao(bd.rs.getString("Email"));
                i.setSiteInstituicao(bd.rs.getString("Site"));
                i.setFacebookInstituicao(bd.rs.getString("Facebook"));
                i.setDataAprovacao(bd.rs.getString("Data_Aprovacao"));
                i.setStatusInstituicao(bd.rs.getString("Status"));
                i.setImg(bd.rs.getInt("img"));
                list.add(i);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public List<Instituicao> listaCod(String codigo) {

        List<Instituicao> list = new ArrayList<Instituicao>();

        String sql = "SELECT * FROM instituicao WHERE responsavel = '" + codigo + "'";
        System.out.println(sql);

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Instituicao i = new Instituicao();
                i.setIdInstituicao(bd.rs.getInt("Codigo"));
                i.setRazaoSocial(bd.rs.getString("Razao_Social"));
                i.setNomeFantasia(bd.rs.getString("Nome_Fantasia"));
                i.setDescricao(bd.rs.getString("descricao"));
                i.setCnpj(bd.rs.getString("CNPJ"));
                i.setEnderecoInstituicao(bd.rs.getString("Endereco"));
                i.setNumero(bd.rs.getString("Numero"));
                i.setBairro(bd.rs.getString("Bairro"));
                i.setCidadeInstituicao(bd.rs.getString("Cidade"));
                i.setEstadoInstituicao(bd.rs.getString("Estado"));
                i.setPaisInstituicao(bd.rs.getString("Pais"));
                i.setCepInstituicao(bd.rs.getString("CEP"));
                i.setTelefoneInstituicao(bd.rs.getString("Telefone"));
                i.setEmailInstituicao(bd.rs.getString("Email"));
                i.setSiteInstituicao(bd.rs.getString("Site"));
                i.setFacebookInstituicao(bd.rs.getString("Facebook"));
                i.setDataAprovacao(bd.rs.getString("Data_Aprovacao"));
                i.setStatusInstituicao(bd.rs.getString("Status"));
                i.setImg(bd.rs.getInt("img"));
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
