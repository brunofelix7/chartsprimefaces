package br.unipe.chartsprimefaces.model;

public class QuerySQL {
	
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
	
	//	Chart 3 e Chart 4
	public static final String QUERY_NOTAS		= "SELECT COUNT(NU_NOTA) AS NOTAS, NM_CIDADE FROM dados WHERE NM_CIDADE = ?";
	
	//	Chart 5
	public static final String QUERY_CLIENTES	= "SELECT COUNT(NM_CLIENTE) AS CLIENTES, UF_CLIENTE FROM dados WHERE UF_CLIENTE = ?";
	
	//	Chart 6
	public static final String QUERY_TOTAL		= "SELECT SUM(VL_TOT_NOTA) AS TOTAL, DT_EMISSAO FROM dados WHERE DT_EMISSAO = ?";
}
