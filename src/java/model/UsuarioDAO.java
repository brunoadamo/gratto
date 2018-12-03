package model;

/**
 *
 * @author MaickHenriquePereira
 */
import service.BD;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO {

    public BD bd;
    public Usuario usuario;

    public UsuarioDAO() {
        bd = new BD();
        usuario = new Usuario();
    }

    /**
     * Grava um usu�rio na Base de Dados
     *
     * @param usuario usuario recebe um objeto do tipo Usuario
     * @return retorna
     */
    public boolean gravar(Usuario usuario) {

        String sql = "INSERT INTO usuario (Nome,Sexo,Cidade,Estado,Telefone,Email,Senha,Ativo) VALUES (?,?,?,?,?,?,?,?)";

        System.out.println(sql);

        try {

            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, usuario.getNomeUsuario());
            bd.st.setString(2, usuario.getSexo());
            bd.st.setString(3, usuario.getCidadeUsuario());
            bd.st.setString(4, usuario.getEstadoUsuario());
            bd.st.setString(5, usuario.getTelefoneUsuario());
            bd.st.setString(6, usuario.getEmailUsuario());
            bd.st.setString(7, usuario.getSenha());
            bd.st.setString(8, "T");

            int n = bd.st.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Falha ao salvar a Doação" + e);
            return false;
        }
    }

    /**
     * Exclu� um Usuario
     *
     * @param codigo recebe o c�digo do usuario que ser� exclu�do
     * @return Retorna a mensagem com o status da opera��o
     */
    public String excluir(int codigo) {

        String sql = "DELETE FROM usuario where IDUsuario = ?;";

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

        return "Usuario exlu�do com sucesso";
    }

    /**
     * ALtera um Usuario
     *
     * @param usuario recebe um objeto do tipo Usuario
     * @return retorna uma mensagem de acordo com as regras definidas
     */
    public String atualizar(Usuario usuario) {

        String sql = "UPDATE usuario SET NomeUsuario = ?, DataNascimentoUsuario = ?, TelefoneUsuario = ?, EmailUsuario = ?, Sexo = ?, CidadeUsuario = ?, DataCriacaoUsuario = ?, EstadoUsuario = ?, UserIsActive = ?,"
                + " WHERE IDUsuario = ?;";

        try {
            bd.getConnection();

            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, usuario.getNomeUsuario());
            bd.st.setString(2, usuario.getDataNascimento());
            bd.st.setString(3, usuario.getTelefoneUsuario());
            bd.st.setString(4, usuario.getEmailUsuario());
            //bd.st.setChar(5, usuario.getSexo());
            bd.st.setString(6, usuario.getCidadeUsuario());
            bd.st.setString(7, usuario.getDataCriacaoUsuario());
            bd.st.setString(8, usuario.getEstadoUsuario());
            bd.st.setBoolean(9, usuario.isUserActive());

            int n = bd.st.executeUpdate();

            return "Usuario Alterado";

        } catch (SQLException erro) {
            System.out.println(erro.toString());
            return "Falha ao alterar o Usuario";

        }
    }

    /**
     * Localiza um Usuario utilizando o c�digo
     *
     * @param codigo codigo do Usuario buscado
     * @return retorna o Usuario preenchido
     */
    public Usuario localizar(int codigo) {

        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuario WHERE IDUsuario = ?";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigo);
            bd.rs = bd.st.executeQuery();
            if (bd.rs.next()) {

                bd.st.setString(1, usuario.getNomeUsuario());
                bd.st.setString(2, usuario.getDataNascimento());
                bd.st.setString(3, usuario.getTelefoneUsuario());
                bd.st.setString(4, usuario.getEmailUsuario());
                //bd.st.setChar(5, usuario.getSexo());
                bd.st.setString(6, usuario.getCidadeUsuario());
                bd.st.setString(7, usuario.getDataCriacaoUsuario());
                bd.st.setString(8, usuario.getEstadoUsuario());
                bd.st.setBoolean(9, usuario.isUserActive());

                return usuario;
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
     * Localiza um Usuario utilizando o nome do Usuario
     *
     * @param codigo codigo do Usuario buscado
     * @return retorna o Usuario preenchido
     */
    public Usuario localizar(String nome) {

        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuario WHERE NomeUsuario LIKE '%?%'";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, nome);
            bd.rs = bd.st.executeQuery();
            if (bd.rs.next()) {

                bd.st.setString(1, usuario.getNomeUsuario());
                bd.st.setString(2, usuario.getDataNascimento());
                bd.st.setString(3, usuario.getTelefoneUsuario());
                bd.st.setString(4, usuario.getEmailUsuario());
                //bd.st.setChar(5, usuario.getSexo());
                bd.st.setString(6, usuario.getCidadeUsuario());
                bd.st.setString(7, usuario.getDataCriacaoUsuario());
                bd.st.setString(8, usuario.getEstadoUsuario());
                bd.st.setBoolean(9, usuario.isUserActive());

                return usuario;
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

    public List<Usuario> listaEvento(String codigo) {

        List<Usuario> list = new java.util.ArrayList<Usuario>();

        String sql = "SELECT usuario.Nome, email FROM evento, participacao, usuario WHERE participacao.cod_evento = '" + codigo + "' AND participacao.cod_evento = evento.codigo AND participacao.cod_usuario = usuario.codigo GROUP BY email";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {
                Usuario i = new Usuario();

                i.setNomeUsuario(bd.rs.getString("Nome"));
                i.setEmailUsuario(bd.rs.getString("Email"));
                list.add(i);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public boolean login() {
        String sql = "SELECT * FROM usuario WHERE Email = ? AND Senha = ?";
        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);

            bd.st.setString(1, usuario.getEmailUsuario());
            bd.st.setString(2, usuario.getSenha());

            bd.rs = bd.st.executeQuery();

            if (bd.rs.next()) {

                usuario.setIdUsuario(bd.rs.getInt("Codigo"));
                usuario.setNomeUsuario(bd.rs.getString("Nome"));
                usuario.setEmailUsuario(bd.rs.getString("Email"));
                usuario.setDataNascimento(bd.rs.getString("Data_Nascimento"));
                usuario.setSexo(bd.rs.getString("Sexo"));
                usuario.setTelefoneUsuario(bd.rs.getString("Telefone"));
                usuario.setCidadeUsuario(bd.rs.getString("Cidade"));
                usuario.setEstadoUsuario(bd.rs.getString("Estado"));
                usuario.setDataCriacaoUsuario(bd.rs.getString("Data_Criacao"));
                usuario.setUserActive(bd.rs.getBoolean("Ativo"));

                return true;
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return false;
    }
}
