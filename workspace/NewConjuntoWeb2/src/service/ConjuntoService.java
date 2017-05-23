package service;

import java.util.ArrayList;

import dao.ConjuntoDAO;
import model.Conjunto;

public class ConjuntoService {
	ConjuntoDAO dao;
	
	public ConjuntoService()
	{
		dao = new ConjuntoDAO();
	}
	
	
	public void criarConjunto(Conjunto to)
	{
		dao.cadastrarConjunto(to);
	}
	
	public Conjunto consultarConjunto(int id)
	{
		return dao.consultarConjunto(id);	
	}
	
	public void alterarConjunto(Conjunto to){
		dao.alterarConjunto(to);
	}
	
	public void excluirConjunto(Conjunto to){
		dao.excluirConjunto(to);
	}
	
	public int consultarNumero(){
		return dao.consultarNumero();
	}
	
	public ArrayList<Conjunto> listarConjuntos(){
		return dao.listarConjuntos();
	}
	
	public Conjunto listarConjunto(String chave)
	{
		return dao.listarConjunto(chave);
	}

}
