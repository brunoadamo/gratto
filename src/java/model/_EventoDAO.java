package model;

/**
 *
 * @author MaickHenriquePereira
 */
import service.BD;
import java.sql.SQLException;
import java.util.List;

public class _EventoDAO {

    private BD bd;
    public Evento evento;

    public _EventoDAO() {
        bd.getConnection();
        evento = new Evento();
    }

    /**
     * Grava uma Evento na Base de Dados
     *
     * @param evento recebe um objeto do tipo Foto
     * @return retorna
     */
    public String gravar(Evento param) {

        String sql = "INSERT INTO evento VALUES (?,?,?,?,?,?,?)";

        try {

            bd.getConnection();

            bd.st = bd.con.prepareStatement(sql);
            //bd.st.setInt(1, usuario.getIdFoto());
            bd.st.setString(1, param.getNome());
            bd.st.setString(2, param.getDesc());
            bd.st.setString(3, param.getDataIni());
            bd.st.setString(4, param.getDataFim());
            bd.st.setString(5, param.getHoraIni());
            bd.st.setString(6, param.getHoraFim());
            bd.st.setInt(7, param.getLimit());
            int n = bd.st.executeUpdate();
            return "Foto salva com sucesso";

        } catch (SQLException e) {
            return "Falha ao salvar a foto" + e;
        }
    }

    /**
     * Exclu� uma Foto
     *
     * @param codigo recebe o c�digo da foto que ser� exclu�da
     * @return Retorna a mensagem com o status da opera��o
     */
    public String excluir(int codigo) {

        String sql = "DELETE FROM evento where codigo = ?;";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigo);
            int n = bd.st.executeUpdate();

        } catch (SQLException erro) {
            return erro.toString();

        } finally {
            bd.close();
        }

        return "Evento excluido com sucesso";
    }

    /**
     * ALtera uma Foto
     *
     * @param foto recebe um objeto do tipo Foto
     * @return retorna uma mensagem de acordo com as regras definidas
     */
    public String atualizar(Evento param) {
        String sql = "UPDATE evento SET Nome = ?, Descricao = ?, Data_Inicio = ?, Data_Fim = ?, Hora_Inicio = ?, Hora_Fim = ?, Limite_Participantes = ?"
                + " WHERE Codigo = ?;";

        try {
            bd.getConnection();

            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, param.getNome());
            bd.st.setString(2, param.getDesc());
            bd.st.setString(3, param.getDataIni());
            bd.st.setString(4, param.getDataFim());
            bd.st.setString(5, param.getHoraIni());
            bd.st.setString(6, param.getHoraFim());
            bd.st.setInt(7, param.getLimit());
            bd.st.setInt(8, param.getIdEvento());

            int n = bd.st.executeUpdate();

            return "Foto Alterada";

        } catch (SQLException erro) {
            System.out.println(erro.toString());
            return "Falha ao alterar a Foto";

        }
    }

    /**
     * Localiza uma Foto utilizando o c�digo
     *
     * @param codigo codigo da Foto a ser buscada
     * @return retorna a Foto preenchida
     */
    public Evento localizar(int codigo) {

        Evento param = new Evento();
        String sql = "SELECT * FROM evento WHERE Codigo = ?";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigo);
            bd.rs = bd.st.executeQuery();
            if (bd.rs.next()) {

                bd.st.setInt(1, param.getIdEvento());
                bd.st.setString(2, param.getNome());
                bd.st.setString(3, param.getDesc());
                bd.st.setString(4, param.getDataIni());
                bd.st.setString(5, param.getDataFim());
                bd.st.setString(6, param.getHoraIni());
                bd.st.setString(7, param.getHoraFim());
                bd.st.setInt(8, param.getLimit());

                return param;
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

    /**
     * Localiza uma Foto utilizando o nome da Foto
     *
     * @param codigo codigo da Foto a ser buscada
     * @return retorna a Foto preenchida
     */
    public Evento localizar(String nome) {

        Evento param = new Evento();
        String sql = "SELECT * FROM evento WHERE Nome LIKE '%?%'";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, nome);
            bd.rs = bd.st.executeQuery();
            if (bd.rs.next()) {

                bd.st.setInt(1, param.getIdEvento());
                bd.st.setString(2, param.getNome());
                bd.st.setString(3, param.getDesc());
                bd.st.setString(4, param.getDataIni());
                bd.st.setString(5, param.getDataFim());
                bd.st.setString(6, param.getHoraIni());
                bd.st.setString(7, param.getHoraFim());
                bd.st.setInt(8, param.getLimit());

                return param;
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
}
