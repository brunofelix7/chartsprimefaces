package br.unipe.chartsprimefaces.model;

public class UserQuerySQL {

	public static final String INSERT_SQL 		= "INSERT INTO users(nome, login, senha) VALUES(?, ?, ?)";
	public static final String UPDATE_SQL 		= "UPDATE users SET nome = ?, login = ?, senha = ? WHERE id = ?";
	public static final String DELETE_SQL 		= "DELETE FROM users WHERE id = ?";
	public static final String SELECT_SQL 		= "SELECT nome, id FROM users";
	public static final String SELECT_ONE_SQL 	= "SELECT * FROM users WHERE id = ?";
	
}
