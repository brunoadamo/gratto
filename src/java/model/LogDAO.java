package model;

/**
 *
 * @author MaickHenriquePereira
 */
import service.BD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogDAO {

    public Log log;
    public BD bd;

    public LogDAO() {
        bd = new BD();
        log = new Log();
    }

    /**
     * Localiza uma Instituicao utilizando o nome Fantasia da Instituicao
     *
     * @param nomeFantasia
     * @param estado
     * @param codigo codigo da Instituicao a ser buscada
     * @return retorna a Instituicao preenchida
     */
    public List<Log> localizar(String param, String field) {

        List<Log> list = new ArrayList<Log>();

        String where = "WHERE TRUE";
        try {
            if (!field.isEmpty()) {
                where = " AND " + field + " = '" + param + "'";
            }
        } catch (Exception e) {
        }

        String sql = "SELECT * FROM logcomportamento" + where;

        System.out.println(sql);

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Log i = new Log();
                i.setIdLog(bd.rs.getInt("Codigo"));
                i.setCodUsuario(bd.rs.getInt("Cod_Usuario"));
                i.setDataHora(bd.rs.getString("Data_Hora"));
                i.setModulo(bd.rs.getString("Modulo"));
                i.setAcao(bd.rs.getString("Acao"));
                i.setParametros(bd.rs.getString("Parametros"));
                list.add(i);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public List<Log> listaTodos() {

        List<Log> list = new ArrayList<Log>();

        String sql = "SELECT * FROM logcomportamento";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {

                Log i = new Log();
                i.setIdLog(bd.rs.getInt("Codigo"));
                i.setCodUsuario(bd.rs.getInt("Cod_Usuario"));
                i.setDataHora(bd.rs.getString("Data_Hora"));
                i.setModulo(bd.rs.getString("Modulo"));
                i.setAcao(bd.rs.getString("Acao"));
                i.setParametros(bd.rs.getString("Parametros"));
                list.add(i);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }
}
