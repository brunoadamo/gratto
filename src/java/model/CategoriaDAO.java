package model;

/**
 *
 * @author MaickHenriquePereira
 */

import service.BD;
import java.sql.SQLException;

public class CategoriaDAO {
	
	private BD bd;
	
	public CategoriaDAO() {
		bd.getConnection();
	}

	/**
	 * Grava uma Categoria na Base de Dados
	 * @param categoria categoria recebe um objeto do tipo Categoria
	 * @return retorna 
	 */
	public String gravar(Categoria categoria) {

		String sql = "INSERT INTO categoria VALUES (?,?,)";

		try {
			
			bd.getConnection();
			
			bd.st = bd.con.prepareStatement(sql);
			//bd.st.setInt(1, usuario.getIdCategoria());
			bd.st.setString(1, categoria.getNomeCategoria());
			bd.st.setBoolean(2, categoria.isCategoryActive());                        
                        
                        
			int n = bd.st.executeUpdate();
			return "Categoria salva com sucesso";


		} catch (SQLException e) {
			return "Falha ao salvar a categoria" + e;
		}
	}
	
	/**
	 * Exclu� uma Categoria
	 * @param codigo recebe o c�digo da categoria que ser� exclu�da
	 * @return Retorna a mensagem com o status da opera��o 
	 */
	public String excluir(int codigo){
		
		String sql = "DELETE FROM categoria where IDCategoria = ?;";
		
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
		
		return "Categoria exlu�da com sucesso";
	}
	
	/**
	 * Altera uma Categoria
	 * @param categoria recebe um objeto do tipo Categoria
	 * @return retorna uma mensagem de acordo com as regras definidas
	 */
	public String atualizar(Categoria categoria){
		
		String sql = "UPDATE categoria SET NomeCategoria = ?, CategoryActive = ?,"
                        + " WHERE IDCategoria = ?;";
		
		try {
			bd.getConnection();
			
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, categoria.getNomeCategoria());
			bd.st.setBoolean(2, categoria.isCategoryActive());
			
			int n = bd.st.executeUpdate();
			
			return "Categoria Alterada";
			
			
		} catch (SQLException erro) {
			System.out.println(erro.toString());
			return "Falha ao alterar a Categoria";
			
		}
	}
	
	/**
	 * Localiza uma Categoria utilizando o c�digo
	 * @param codigo codigo da Categoria a ser buscada
	 * @return retorna a Categoria preenchida
	 */
	public Categoria localizar(int codigo) {
		
		Categoria categoria = new Categoria();
		String sql = "SELECT * FROM categoria WHERE IDCategoria = ?";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()){
				
				bd.st.setString(1, categoria.getNomeCategoria());
			bd.st.setBoolean(2, categoria.isCategoryActive());
				
				return categoria;
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
	 * Localiza uma Categoria utilizando o nome da Categoria
	 * @param codigo codigo da Categoria a ser buscada
	 * @return retorna a Categoria preenchida
	 */
	public Categoria localizar(String nome) {
		
		Categoria categoria = new Categoria();
		String sql = "SELECT * FROM categoria WHERE NomeCategoria LIKE '%?%'";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, nome);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()){
				
				bd.st.setString(1, categoria.getNomeCategoria());
			bd.st.setBoolean(2, categoria.isCategoryActive());
				
				return categoria;
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

