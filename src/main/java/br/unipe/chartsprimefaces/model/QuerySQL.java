package br.unipe.chartsprimefaces.model;

public class QuerySQL {

	public static final String INSERT_SQL 		= "INSERT INTO users(nome, login, senha) VALUES(?, ?, ?)";
	public static final String UPDATE_SQL 		= "UPDATE users SET nome = ?, login = ?, senha = ? WHERE id = ?";
	public static final String DELETE_SQL 		= "DELETE FROM users WHERE id = ?";
	public static final String SELECT_SQL 		= "SELECT nome, id FROM users";
	public static final String SELECT_ONE_SQL 	= "SELECT * FROM users WHERE id = ?";
	
	//	Chart 1
	public static final String QUERY_JP			= "SELECT NM_CIDADE, DT_EMISSAO, SUM(VL_ITEM) AS VALOR "
												+ " FROM dados "
												+ " WHERE NM_CIDADE IN ('JOAO PESSOA') "
												+ " AND DT_EMISSAO BETWEEN ? AND ?"
												+ " group by NM_CIDADE, DT_EMISSAO "
												+ " ORDER BY DT_EMISSAO";
	
	//	Chart 2
	public static final String QUERY_RECIFE		= "SELECT NM_CIDADE, DT_EMISSAO, SUM(VL_ITEM) AS VALOR "
												+ " FROM dados "
												+ " WHERE NM_CIDADE IN ('RECIFE') "
												+ " AND DT_EMISSAO BETWEEN ? AND ?"
												+ " group by NM_CIDADE, DT_EMISSAO "
												+ " ORDER BY DT_EMISSAO";
	
	//	Chart 3
	public static final String QUERY_NOTAS		= "SELECT COUNT(NU_NOTA) AS NOTAS FROM dados WHERE NM_CIDADE = ?";
	
	
}