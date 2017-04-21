package model;
import java.io.Serializable;

public class Conjunto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private int id_conjunto;
	private boolean status;
	private double valor;
	private double medida;
	private int tempoLocacao;
	private String observacao;

	public void setId_conjunto(int id_conjunto) {
		this.id_conjunto = id_conjunto;
	}

	public int getId_conjunto() {
		return id_conjunto;
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

	public double getMedida() {
		return medida;
	}

	public void setMedida(double medida) {
		this.medida = medida;
	}

	public int getTempoLocacao() {
		return tempoLocacao;
	}

	public void setTempoLocacao(int tempoLocacao) {
		this.tempoLocacao = tempoLocacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



}