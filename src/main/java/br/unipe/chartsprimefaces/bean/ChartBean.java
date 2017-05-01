package br.unipe.chartsprimefaces.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
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
    
    //	TESTES
    public void list(){
    	mList = new ArrayList<>();
    	myDataService = new MyDataService();
    	mList = myDataService.listFaturamentoJP();
    	createChartModel(mList);
    }
    private void createChartModel(List<MyData> data){
    	pieModel = new PieChartModel();
    	for(MyData m : data){
    		pieModel.set(m.getData(), m.getValor());
    	}
    	pieModel.setTitle("Faturamento");
        pieModel.setLegendPosition("e");
        pieModel.setFill(false);
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(300);
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
