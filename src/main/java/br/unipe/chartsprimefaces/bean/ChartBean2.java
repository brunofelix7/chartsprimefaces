package br.unipe.chartsprimefaces.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import br.unipe.chartsprimefaces.entity.MyData;
import br.unipe.chartsprimefaces.service.MyDataService;

@ManagedBean(name = "chartView2")
public class ChartBean2 {

	private String date;
	private String date2;
	private String label; 
	private BarChartModel barChartModel;
	private ChartSeries chartSeries;
	private List<MyData> mList;
	private MyDataService myDataService;
	
    @PostConstruct
    public void init() {
        
    }
    
    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Preencha todos os campos"));
    }
    
    public String getValueDate1(){
        System.out.println("Valor digitado: " + date);
        return date;
    }
    
    public String getValueDate2(){
        System.out.println("Valor digitado: " + date2);
        return date2;
    }
    
    public void list(){
    	mList = new ArrayList<>();
    	myDataService = new MyDataService();
    	mList = myDataService.listFaturamentoRecife(getValueDate1(), getValueDate2());
    	createChartModel(mList);
    }
    
    private void createChartModel(List<MyData> data){
    	chartSeries = new ChartSeries();
    	chartSeries.setLabel("Total");
    	for(MyData m : data){
    		chartSeries.set(m.getData(), m.getValor());
    	}
    	
    	barChartModel = new BarChartModel();
    	barChartModel.addSeries(chartSeries);
    	barChartModel.setTitle("Total de Faturamento em Recife");
    	barChartModel.setLegendPosition("e");
    }
    

    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BarChartModel getBarChartModel() {
		return barChartModel;
	}

	public void setBarChartModel(BarChartModel barChartModel) {
		this.barChartModel = barChartModel;
	}

}
