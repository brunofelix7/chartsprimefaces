package br.unipe.chartsprimefaces.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DATABASE = "jdbc:mysql://localhost:3306/db_primefaces";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
		}catch(SQLException e){
			throw new RuntimeException("Erro ao conectar com o banco de dados. ", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Classe não encontrada. ", e);
		} 
	}
	
}
