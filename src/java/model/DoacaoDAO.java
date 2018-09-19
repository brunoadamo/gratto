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
public class DoacaoDAO {
    
    public Doacao doacao;
    public BD bd;

    public DoacaoDAO() {
        bd = new BD();
        doacao = new Doacao();
    }
    
    public boolean gravar(Doacao doacao) {

        String sql = "INSERT INTO Doacao (Data, Valor, Cod_Inst, Cod_Usuario) VALUES (?,?,?,?)";

        try {

            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, doacao.getData());
            bd.st.setDouble(2, doacao.getValor());
            bd.st.setInt(3, doacao.getCod_inst());
            bd.st.setInt(4, doacao.getCod_usuario());
            //bd.st.setBoolean(17, instituicao.instIsActive());

            int n = bd.st.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Falha ao salvar a Doação" + e);
            return false;
        }
    }
    
    public List<Doacao> localizar(String codigo) {

        List<Doacao> list = new java.util.ArrayList<Doacao>();

        String sql = "SELECT * FROM doacao WHERE Cod_Usuario = '" + codigo +"'";       
        

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

        String sql = "SELECT * FROM doacao WHERE Cod_Inst = '" + codigoInst +"'";       
        
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
