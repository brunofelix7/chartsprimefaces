package br.unipe.chartsprimefaces.dao;

import java.util.List;
import br.unipe.chartsprimefaces.entity.MyData;

public interface MyDataDAO {

	List<MyData> listFaturamentoJP(String date1, String date2);
	
	List<MyData> listFaturamentoRecife(String date1, String date2);
	
	List<MyData> listNotas(String cidade);
	
	List<MyData> listClientes(String uf);
	
	List<MyData> listTotal(String data);
	
	
}
