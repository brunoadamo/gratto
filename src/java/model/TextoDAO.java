package model;

/**
 *
 * @author MaickHenriquePereira
 */

import service.BD;
import java.sql.SQLException;

public class TextoDAO {
	
	private BD bd;
	
	public TextoDAO() {
		bd.getConnection();
	}

	/**
	 * Grava um Texto na Base de Dados
	 * @param texto texto recebe um objeto do tipo Texto
	 * @return retorna 
	 */
	public String gravar(Texto texto) {

		String sql = "INSERT INTO texto VALUES (?,?,?)";

		try {
			
			bd.getConnection();
			
			bd.st = bd.con.prepareStatement(sql);
			//bd.st.setInt(1, usuario.getIdFoto());
                        bd.st.setString(1, texto.getDescricao());
			bd.st.setString(2, texto.getDataPublicacao());
			bd.st.setBoolean(3, texto.isTextActive());
                        
                        
                        
                        
			int n = bd.st.executeUpdate();
			return "Texto salvo com sucesso";


		} catch (SQLException e) {
			return "Falha ao salvar o texto" + e;
		}
	}
	
	/**
	 * Exclu� um Texto
	 * @param codigo recebe o c�digo do texto que ser� exclu�do
	 * @return Retorna a mensagem com o status da opera��o 
	 */
	public String excluir(int codigo){
		
		String sql = "DELETE FROM texto where IDTexto = ?;";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			int n = bd.st.executeUpdate();
			
		} catch (SQLException erro) {
			return erro.toString();
			
		}
		finally {
			bd.close();
		}
		
		return "Texto exlu�do com sucesso";
	}
	
	/**
	 * Altera um Texto
	 * @param texto recebe um objeto do tipo Texto
	 * @return retorna uma mensagem de acordo com as regras definidas
	 */
	public String atualizar(Texto texto){
		
		String sql = "UPDATE texto SET Descricao = ?, DataPublicacao = ?, TextActive = ?,"
                        + " WHERE IDTexto = ?;";
		
		try {
			bd.getConnection();
			
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, texto.getDescricao());
			bd.st.setString(2, texto.getDataPublicacao());
			bd.st.setBoolean(3, texto.isTextActive());
			
			int n = bd.st.executeUpdate();
			
			return "Texto Alterado";
			
			
		} catch (SQLException erro) {
			System.out.println(erro.toString());
			return "Falha ao alterar o Texto";
			
		}
	}
	
	/**
	 * Localiza um Texto utilizando o c�digo
	 * @param codigo codigo do Texto a ser buscado
	 * @return retorna o Texto preenchido
	 */
	public Texto localizar(int codigo) {
		
		Texto texto = new Texto();
		String sql = "SELECT * FROM texto WHERE IDTexto = ?";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()){
				
				bd.st.setString(1, texto.getDescricao());
			bd.st.setString(2, texto.getDataPublicacao());
			bd.st.setBoolean(3, texto.isTextActive());
                                               
				
				return texto;
			}else{
				return null;
			}
			
			
		} catch (SQLException erro) {
			System.out.println(erro.toString());
			return null;
			
		}
		finally {
			bd.close();
		}
	}
	
	
	
}

