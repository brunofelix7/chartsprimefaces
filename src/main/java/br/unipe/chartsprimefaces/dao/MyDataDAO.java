package br.unipe.chartsprimefaces.dao;

import java.util.List;

import br.unipe.chartsprimefaces.entity.MyData;

/**
 * Contém todos os 6 métodos de retorno dos dados
 */
public interface MyDataDAO {

	List<MyData> listFaturamentoJP(String date1, String date2);
	
	List<MyData> listFaturamentoRecife(String date1, String date2);
	
	List<MyData> listNotas(String cidade);
	
	List<MyData> listNotas2(String cidade);

	
}
