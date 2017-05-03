package br.unipe.chartsprimefaces.bean;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;
import br.unipe.chartsprimefaces.entity.MyData;
import br.unipe.chartsprimefaces.service.MyDataService;

@ManagedBean(name = "chartView")
public class ChartBean {

	private String date;
	private String date2;
	private String label; 
	private PieChartModel pieModel;
	private BarChartModel barModel;
	private LineChartModel lineChartModel;
	private ChartSeries boys;
	private ChartSeries girls;
	private Axis xAxis;
	private Axis yAxis;	
	private List<MyData> mList;
	private MyDataService myDataService;
	
    @PostConstruct
    public void init() {
        createBarModels();
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
    	mList = myDataService.listFaturamentoJP(getValueDate1(), getValueDate2());
    	createChartModel(mList);
    }
    
    private void createChartModel(List<MyData> data){
    	pieModel = new PieChartModel();
    	Locale ptBr = new Locale("pt", "BR");
    	
    	for(MyData m : data){
    		String valorReal = NumberFormat.getCurrencyInstance(ptBr).format(m.getValor());
    		System.out.println(valorReal + "\n");
    		pieModel.set(m.getData(), m.getValor());
    	}
    	
    	pieModel.setTitle("Total de Faturamento em João Pessoa entre " + getValueDate1() + " e " + getValueDate2());
        pieModel.setShowDataLabels(true);
        pieModel.setLegendPosition("w");
        pieModel.setFill(true);
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 135);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
    	barModel = initBarModel();
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         
        xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
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

	public BarChartModel getBarModel() {
        return barModel;
    }
    
    public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
    
    public PieChartModel getPieModel() {
		return pieModel;
	}
    
    public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public LineChartModel getLineChartModel() {
		return lineChartModel;
	}

	public void setLineChartModel(LineChartModel lineChartModel) {
		this.lineChartModel = lineChartModel;
	}
    
    
    
}
