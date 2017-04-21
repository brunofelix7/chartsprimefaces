package br.unipe.chartsprimefaces.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import br.unipe.chartsprimefaces.entity.User;
import br.unipe.chartsprimefaces.service.UserService;

@ManagedBean(name = "chartView")
public class ChartBean {

	private PieChartModel pieModel;
	private BarChartModel barModel;
	private ChartSeries boys;
	private ChartSeries girls;
	private Axis xAxis;
	private Axis yAxis;	
	private List<User> users;
	private UserService userService;
	
    @PostConstruct
    public void init() {
        createBarModels();
    }
    
    public void list(){
    	try{
    		users = new ArrayList<>();
    		userService = new UserService();
			users = userService.buscarTodos();
			createChartModel(users);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
		}
    }
    
    private void createChartModel(List<User> users){
    	pieModel = new PieChartModel();
    	
        for (User user : users) {
            pieModel.set(user.getNome(), user.getId());
        }
        pieModel.setTitle("Usuários");
        pieModel.setLegendPosition("e");
        pieModel.setFill(false);
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(150);
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
    
}
