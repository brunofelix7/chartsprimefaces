package br.unipe.chartsprimefaces.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;
import br.unipe.chartsprimefaces.entity.MyData;
import br.unipe.chartsprimefaces.service.MyDataService;

@ManagedBean(name = "chartView6")
public class ChartBean6 {

	private String data;
	private PieChartModel pieModel;
	private List<MyData> mList;
	private MyDataService myDataService;
	
    @PostConstruct
    public void init() {
        
    }
    
    public String getValueData(){
        System.out.println("Valor digitado: " + data);
        return data;
    }

    
    public void list(){
    	mList = new ArrayList<>();
    	myDataService = new MyDataService();
    	mList = myDataService.listTotal(getValueData());
    	createChartModel(mList);
    }
    
    private void createChartModel(List<MyData> data){
    	pieModel = new PieChartModel();
    	
    	for(MyData m : data){
    		pieModel.set(m.getData(), m.getValor());
    	}
    	
    	pieModel.setTitle("Valor Total na data " + getValueData());
        pieModel.setShowDataLabels(true);
        pieModel.setLegendPosition("e");
        pieModel.setFill(false);
    }

    
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public PieChartModel getPieModel() {
		return pieModel;
	}
	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}
	public List<MyData> getmList() {
		return mList;
	}
	public void setmList(List<MyData> mList) {
		this.mList = mList;
	}

}
