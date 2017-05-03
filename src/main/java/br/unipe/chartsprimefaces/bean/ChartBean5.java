package br.unipe.chartsprimefaces.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import br.unipe.chartsprimefaces.entity.MyData;
import br.unipe.chartsprimefaces.service.MyDataService;

@ManagedBean(name = "chartView5")
public class ChartBean5 {

	private String uf1;
	private String uf2;
	private BarChartModel barChartModel;
	private Map<String, String> estados;
	private List<MyData> mList;
	private List<MyData> mList2;
	private MyDataService myDataService;
	
    @PostConstruct
    public void init() {
        estados = new HashMap<String, String>();
        estados.put("PB", "PB");
        estados.put("PE", "PE");
        estados.put("BA", "BA");
    }
    
   
    public String getValueEstado1(){
        System.out.println("Valor digitado: " + uf1);
        return uf1;
    }
    
    public String getValueEstado2(){
        System.out.println("Valor digitado: " + uf2);
        return uf2;
    }

    
    public void list(){
    	mList = new ArrayList<>();
    	mList2 = new ArrayList<>();
    	myDataService = new MyDataService();
    	mList = myDataService.listClientes("PB");
    	mList2 = myDataService.listClientes("BA");
    	createChartModel(mList, mList2);
    }
    
    private void createChartModel(List<MyData> u1, List<MyData> u2){
    	
    	ChartSeries estado1 = new ChartSeries();
    	ChartSeries estado2 = new ChartSeries();
    	
    	for(MyData es1 : u1){
    		estado1.set(es1.getUf(), es1.getCliente());
    	}
    	
    	for(MyData es2 : u2){
    		estado2.set(es2.getUf(), es2.getCliente());
    	}
    	
    	estado1.setLabel(getValueEstado1());
    	estado2.setLabel(getValueEstado2());
    	
    	barChartModel = new BarChartModel();
    	barChartModel.addSeries(estado1);
    	barChartModel.addSeries(estado2);
    	barChartModel.setTitle("Total de Clientes em " + getValueEstado1() + " e " + getValueEstado2());
    	barChartModel.setLegendPosition("e");
    }


    public String getUf1() {
		return uf1;
	}
	public void setUf1(String uf1) {
		this.uf1 = uf1;
	}
	public String getUf2() {
		return uf2;
	}
	public void setUf2(String uf2) {
		this.uf2 = uf2;
	}
	public BarChartModel getBarChartModel() {
		return barChartModel;
	}
	public void setBarChartModel(BarChartModel barChartModel) {
		this.barChartModel = barChartModel;
	}
	public Map<String, String> getEstados() {
		return estados;
	}
	public void setEstados(Map<String, String> estados) {
		this.estados = estados;
	}
	public List<MyData> getmList() {
		return mList;
	}
	public void setmList(List<MyData> mList) {
		this.mList = mList;
	}
	public List<MyData> getmList2() {
		return mList2;
	}
	public void setmList2(List<MyData> mList2) {
		this.mList2 = mList2;
	}

    
}
