package br.unipe.chartsprimefaces.entity;

public class MyData {
	
	private String data;
	private String cidade;
	private double valor;
	private int notas;
	
	public MyData(){
		
	}
	
	public MyData(String data, String cidade, double valor) {
		super();
		this.data = data;
		this.cidade = cidade;
		this.valor = valor;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getNotas() {
		return notas;
	}
	public void setNotas(int notas) {
		this.notas = notas;
	}
	

}
