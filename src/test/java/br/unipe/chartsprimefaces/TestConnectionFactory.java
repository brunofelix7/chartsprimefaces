package br.unipe.chartsprimefaces;

import org.junit.Test;
import br.unipe.chartsprimefaces.dao.ConnectionFactory;

public class TestConnectionFactory {
	
	@Test
	public void conn() throws Exception{
		ConnectionFactory.getConnection();
	}
}
