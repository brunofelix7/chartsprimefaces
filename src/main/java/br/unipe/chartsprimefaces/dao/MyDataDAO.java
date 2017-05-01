package br.unipe.chartsprimefaces.dao;

import java.util.List;

import br.unipe.chartsprimefaces.entity.MyData;

/**
 * Contém todos os 6 métodos de retorno dos dados
 */
public interface MyDataDAO {

	List<MyData> listFaturamentoJP(String date1, String date2);
	
}
