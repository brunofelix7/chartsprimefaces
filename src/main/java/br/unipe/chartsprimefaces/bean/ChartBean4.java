package br.unipe.chartsprimefaces.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;
import br.unipe.chartsprimefaces.entity.MyData;
import br.unipe.chartsprimefaces.service.MyDataService;

@ManagedBean(name = "chartView4")
public class ChartBean4 {

	private String city;
	private PieChartModel pieModel;
	private LineChartModel lineChartModel;
	private Map<String, String> cidades;
	private List<MyData> mList;
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
    
    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Preencha todos os campos"));
    }
    
    public String getValueCity(){
        System.out.println("Valor digitado: " + city);
        return city;
    }

    
    public void list(){
    	mList = new ArrayList<>();
    	myDataService = new MyDataService();
    	mList = myDataService.listNotas(getValueCity());
    	createChartModel(mList);
    }
    
    private void createChartModel(List<MyData> data){
    	pieModel = new PieChartModel();
    	
    	for(MyData m : data){
    		pieModel.set(m.getCidade(), m.getNotas());
    	}
    	
    	pieModel.setTitle("Total de Notas em " + getValueCity());
        pieModel.setShowDataLabels(true);
        pieModel.setLegendPosition("e");
        pieModel.setFill(true);
    }
     
    
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Map<String, String> getCidades() {
		return cidades;
	}

	public void setCidades(Map<String, String> cidades) {
		this.cidades = cidades;
	}

}
