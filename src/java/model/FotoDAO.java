package model;

/**
 *
 * @author MaickHenriquePereira
 */

import service.BD;
import java.sql.SQLException;

public class FotoDAO {
	
	private BD bd;
	
	public FotoDAO() {
		bd.getConnection();
	}

	/**
	 * Grava uma Foto na Base de Dados
	 * @param foto foto recebe um objeto do tipo Foto
	 * @return retorna 
	 */
	public String gravar(Foto foto) {

		String sql = "INSERT INTO foto VALUES (?,?,?,?,?)";

		try {
			
			bd.getConnection();
			
			bd.st = bd.con.prepareStatement(sql);
			//bd.st.setInt(1, usuario.getIdFoto());
			bd.st.setString(1, foto.getNomeFoto());
			bd.st.setString(2, foto.getDescricaoFoto());
			bd.st.setString(3, foto.getCaminho());
			bd.st.setString(4, foto.getDataPublicacao());
                        bd.st.setBoolean(5, foto.isPhotoActive());
                        
			int n = bd.st.executeUpdate();
			return "Foto salva com sucesso";


		} catch (SQLException e) {
			return "Falha ao salvar a foto" + e;
		}
	}
	
	/**
	 * Exclu� uma Foto
	 * @param codigo recebe o c�digo da foto que ser� exclu�da
	 * @return Retorna a mensagem com o status da opera��o 
	 */
	public String excluir(int codigo){
		
		String sql = "DELETE FROM foto where IDFoto = ?;";
		
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
		
		return "Foto exlu�da com sucesso";
	}
	
	/**
	 * ALtera uma Foto
	 * @param foto recebe um objeto do tipo Foto
	 * @return retorna uma mensagem de acordo com as regras definidas
	 */
	public String atualizar(Foto foto){
		
		String sql = "UPDATE foto SET NomeFoto = ?, DescricaoFoto = ?, caminho = ?, EmailUsuario = ?, DataPublicacao = ?, PhotoActive = ?,"
                        + " WHERE IDFoto = ?;";
		
		try {
			bd.getConnection();
			
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, foto.getNomeFoto());
			bd.st.setString(2, foto.getDescricaoFoto());
			bd.st.setString(3, foto.getCaminho());
			bd.st.setString(4, foto.getDataPublicacao());
                        bd.st.setBoolean(5, foto.isPhotoActive());
			
			int n = bd.st.executeUpdate();
			
			return "Foto Alterada";
			
			
		} catch (SQLException erro) {
			System.out.println(erro.toString());
			return "Falha ao alterar a Foto";
			
		}
	}
	
	/**
	 * Localiza uma Foto utilizando o c�digo
	 * @param codigo codigo da Foto a ser buscada
	 * @return retorna a Foto preenchida
	 */
	public Foto localizar(int codigo) {
		
		Foto foto = new Foto();
		String sql = "SELECT * FROM foto WHERE IDFoto = ?";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()){
				
                        bd.st.setString(1, foto.getNomeFoto());
			bd.st.setString(2, foto.getDescricaoFoto());
			bd.st.setString(3, foto.getCaminho());
			bd.st.setString(4, foto.getDataPublicacao());
                        bd.st.setBoolean(5, foto.isPhotoActive());
				
				return foto;
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
	
	/**
	 * Localiza uma Foto utilizando o nome da Foto
	 * @param codigo codigo da Foto a ser buscada
	 * @return retorna a Foto preenchida
	 */
	public Foto localizar(String nome) {
		
		Foto foto = new Foto();
		String sql = "SELECT * FROM foto WHERE NomeFoto LIKE '%?%'";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, nome);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()){
				
				bd.st.setString(1, foto.getNomeFoto());
			bd.st.setString(2, foto.getDescricaoFoto());
			bd.st.setString(3, foto.getCaminho());
			bd.st.setString(4, foto.getDataPublicacao());
                        bd.st.setBoolean(5, foto.isPhotoActive());
				
				return foto;
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

