/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;
import service.BD;

/**
 *
 * @author Bruno
 */
public class ParticipacaoDAO {

    public Participacao participacao;
    public BD bd;

    public ParticipacaoDAO() {
        bd = new BD();
        participacao = new Participacao();
    }

    public boolean gravar(Participacao participacao) {

        String sql = "INSERT INTO participacao (Data_Inscricao, Cod_Usuario, Cod_Evento, Cod_Instituicao) VALUES (?,?,?,?)";

        try {

            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, participacao.getDataInsc());
            bd.st.setDouble(2, participacao.getCod_usuario());
            bd.st.setInt(3, participacao.getCod_evento());
            bd.st.setInt(4, participacao.getCod_instituicao());
            //bd.st.setBoolean(17, instituicao.instIsActive());

            int n = bd.st.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Falha ao salvar a Participacao" + e);
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

        String sql = "DELETE FROM participacao where Codigo = ?;";

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

    public List<Doacao> localizar(String codigo) {

        List<Doacao> list = new java.util.ArrayList<Doacao>();

        String sql = "SELECT * FROM doacao WHERE Cod_Usuario = '" + codigo + "'";

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {

                Doacao d = new Doacao();
                d.setCodigo(bd.rs.getInt("Codigo"));
                d.setCod_inst(bd.rs.getInt("Cod_Inst"));
                d.setCod_usuario(bd.rs.getInt("Cod_Usuario"));
                d.setValor(bd.rs.getDouble("Valor"));
                d.setData(bd.rs.getString("Data"));

                list.add(d);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

    public List<Doacao> localizarInsDoacao(String codigoInst) {

        List<Doacao> list = new java.util.ArrayList<Doacao>();

        String sql = "SELECT * FROM doacao WHERE Cod_Inst = '" + codigoInst + "'";

        System.out.println(sql);

        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();

            while (bd.rs.next()) {

                Doacao d = new Doacao();
                d.setCodigo(bd.rs.getInt("Codigo"));
                d.setCod_inst(bd.rs.getInt("Cod_Inst"));
                d.setCod_usuario(bd.rs.getInt("Cod_Usuario"));
                d.setValor(bd.rs.getDouble("Valor"));
                d.setData(bd.rs.getString("Data"));

                list.add(d);
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.toString());
        }
        return list;
    }

}
