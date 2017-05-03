package br.unipe.chartsprimefaces.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import br.unipe.chartsprimefaces.entity.MyData;
import br.unipe.chartsprimefaces.service.MyDataService;

@ManagedBean(name = "chartView3")
public class ChartBean3 {

	private String cidade1;
	private String cidade2;
	private String city;
	private String label; 
	private BarChartModel barModel;
	private HorizontalBarChartModel horizontalBarModel;
	private ChartSeries chartSeries;
	private ChartSeries chartSeries2;
	private List<MyData> mList;
	private List<MyData> mList2;
	private Map<String, String> cidades;
	private MyDataService myDataService;
	
    @PostConstruct
    public void init() {
    	cidades = new HashMap<String, String>();
    	cidades.put("JOAO PESSOA", "JOAO PESSOA");
    	cidades.put("RECIFE", "RECIFE");
    	cidades.put("BAYEUX", "BAYEUX");
    	cidades.put("SANTA RITA", "SANTA RITA");
    	cidades.put("CABEDELO", "CABEDELO");
    	cidades.put("CONDE", "CONDE");
    }
    
    public String getValueCidade1(){
        System.out.println("Valor digitado: " + cidade1);
        return cidade1;
    }
    
    public String getValueCidade2(){
        System.out.println("Valor digitado: " + cidade2);
        return cidade2;
    }
    
    public void list(){
    	mList = new ArrayList<>();
    	mList2 = new ArrayList<>();
    	myDataService = new MyDataService();
    	mList = myDataService.listNotas(getValueCidade1());
    	mList2 = myDataService.listNotas2(getValueCidade2());
    	createChartModel(mList, mList2);
    }
    
    private void createChartModel(List<MyData> cidade1, List<MyData> cidade2){
    	ChartSeries cs1 = new ChartSeries();
    	ChartSeries cs2 = new ChartSeries();
    	for(MyData c1 : cidade1){
    		cs1.set(c1.getCidade(), c1.getNotas());
    	}
    	
    	for(MyData c2 : cidade2){
    		cs2.set(c2.getCidade(), c2.getNotas());
    	}
    	
    	cs1.setLabel("Total");
    	cs2.setLabel("Total");
    	
    	horizontalBarModel = new HorizontalBarChartModel();
    	horizontalBarModel.addSeries(cs1);
    	horizontalBarModel.addSeries(cs2);
    	horizontalBarModel.setTitle("Total de Notas Fiscais");
    	horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
    	
    	Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");  
    }
    
    
    
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCidade1() {
		return cidade1;
	}
	public void setCidade1(String cidade1) {
		this.cidade1 = cidade1;
	}
	public String getCidade2() {
		return cidade2;
	}
	public void setCidade2(String cidade2) {
		this.cidade2 = cidade2;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}
	public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
		this.horizontalBarModel = horizontalBarModel;
	}
	public BarChartModel getBarModel() {
		return barModel;
	}
	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	public Map<String, String> getCidades() {
		return cidades;
	}
	public void setCidades(Map<String, String> cidades) {
		this.cidades = cidades;
	}

}
