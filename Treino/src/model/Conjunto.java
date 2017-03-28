package model;

import java.io.Serializable;

public class Conjunto implements Serializable
/*Serializable, significa que voce vai conseguir 
//fazer uma copia do objeto. No estado que ele se encontra
naquele determinado momento*/
{
	private static final long serialVersionUID = 1L;
	private int idConjunto;
	private boolean status;
	private double valor;
	private double tempoLocacao;//Meses
	private double medida;//por M^2
	private String observacao;
	
	public Conjunto()
	{
		setStatus(false);
		setValor(0.0);
		setTempoLocacao(0.0);
		setMedida(0.0);
		setObservacao(null);
	}
	public Conjunto(int id,boolean status,double valor,double tempoLocacao,double medida,String obseracao)
	{
		setIdConjunto(id);
		setStatus(status);
		setValor(valor);
		setTempoLocacao(tempoLocacao);
		setMedida(medida);
		setObservacao(obseracao);		
	}
	public int getIdConjunto() {
		return idConjunto;
	}
	public void setIdConjunto(int idConjunto) {
		this.idConjunto = idConjunto;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getTempoLocacao() {
		return tempoLocacao;
	}
	public void setTempoLocacao(double tempoLocacao) {
		this.tempoLocacao = tempoLocacao;
	}
	public double getMedida() {
		return medida;
	}
	public void setMedida(double medida) {
		this.medida = medida;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	@Override
	public String toString() {
		return "Conjunto [id_Conjunto=" + idConjunto + ", status=" + status + ", preco=" + valor + ", medida=" + medida
				+ ", observacao=" + observacao + "]";
	}
}
