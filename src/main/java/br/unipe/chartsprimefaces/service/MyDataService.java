package br.unipe.chartsprimefaces.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.unipe.chartsprimefaces.dao.ConnectionFactory;
import br.unipe.chartsprimefaces.dao.MyDataDAO;
import br.unipe.chartsprimefaces.entity.MyData;
import br.unipe.chartsprimefaces.model.QuerySQL;

public class MyDataService implements MyDataDAO{

	private MyData mData;
	private ResultSet result;
	private PreparedStatement statement;
	private Connection conn = ConnectionFactory.getConnection();

	@Override
	public List<MyData> listFaturamentoJP(String date1, String date2){
		List<MyData> mList = new ArrayList<>();
		
		try{
			statement = conn.prepareStatement(QuerySQL.QUERY_JP);
			statement.setString(1, date1);
			statement.setString(2, date2);
			result = statement.executeQuery();
			
			while(result.next()){
				mData = new MyData();
				
				mData.setCidade(result.getString("NM_CIDADE"));
				mData.setData(result.getString("DT_EMISSAO"));
				mData.setValor(result.getDouble("VALOR"));
				
				mList.add(mData);
			}
			result.close();
			statement.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return mList;

	}

	@Override
	public List<MyData> listFaturamentoRecife(String date1, String date2) {
		List<MyData> mList = new ArrayList<>();
		
		try{
			statement = conn.prepareStatement(QuerySQL.QUERY_RECIFE);
			statement.setString(1, date1);
			statement.setString(2, date2);
			result = statement.executeQuery();
			
			while(result.next()){
				mData = new MyData();
				
				mData.setCidade(result.getString("NM_CIDADE"));
				mData.setData(result.getString("DT_EMISSAO"));
				mData.setValor(result.getDouble("VALOR"));
				
				mList.add(mData);
			}
			result.close();
			statement.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public List<MyData> listNotas(String cidade) {
		List<MyData> mList = new ArrayList<>();
		
		try{
			statement = conn.prepareStatement(QuerySQL.QUERY_NOTAS);
			statement.setString(1, cidade);
			result = statement.executeQuery();
			
			while(result.next()){
				mData = new MyData();
				mData.setCidade(result.getString("NM_CIDADE"));
				mData.setNotas(result.getInt("NOTAS"));
				
				mList.add(mData);
			}
			/*result.close();
			statement.close();
			conn.close();*/
		}catch(SQLException e){
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public List<MyData> listClientes(String uf) {
		List<MyData> mList = new ArrayList<>();
		
		try{
			statement = conn.prepareStatement(QuerySQL.QUERY_CLIENTES);
			statement.setString(1, uf);
			result = statement.executeQuery();
			
			while(result.next()){
				mData = new MyData();
				mData.setUf(result.getString("UF_CLIENTE"));
				mData.setCliente(result.getInt("CLIENTES"));
				
				mList.add(mData);
			}
			/*result.close();
			statement.close();
			conn.close();*/
		}catch(SQLException e){
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public List<MyData> listTotal(String data) {
List<MyData> mList = new ArrayList<>();
		
		try{
			statement = conn.prepareStatement(QuerySQL.QUERY_TOTAL);
			statement.setString(1, data);
			result = statement.executeQuery();
			
			while(result.next()){
				mData = new MyData();
				mData.setData(result.getString("DT_EMISSAO"));
				mData.setValor(result.getDouble("TOTAL"));
				
				mList.add(mData);
			}
			result.close();
			statement.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return mList;
	}

}
