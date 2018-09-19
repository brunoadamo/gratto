package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {

	public Connection con = null;
	public PreparedStatement st = null;
	public ResultSet rs = null;
	
	private final String DRIVER = "com.mysql.jdbc.Driver"; //caminho do driver
	private final String BANCO = "gratto";
	private final String URL   = "jdbc:mysql://localhost:3306/"+BANCO+"?autoReconnect=true&useSSL=false";
	private final String LOGIN = "root";
	private final String SENHA = "12345678";
	
	
	public boolean getConnection(){
		try {
			Class.forName(DRIVER);
			System.out.println("Carregou driver");
			
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou!");
			
			return true;
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Falha " + e.toString());
			return false;
		}
		catch (SQLException e) {
			System.out.println("Falha " + e.toString());
			return false;
		}
	}
	
	public void close(){
		try {
			if(rs!=null) rs.close();
		} catch (SQLException e) {
		}
		try {
			if(st!=null) st.close();
		} catch (SQLException e) {
		}
		try {
			if(con!=null) con.close();
			System.out.println("Desconectou!");
		} catch (SQLException e) {
		}
	}
	
	public static void main(String[] args) {
		BD bd = new BD();
		
		bd.getConnection();
		bd.close();
	}
	
	
}
