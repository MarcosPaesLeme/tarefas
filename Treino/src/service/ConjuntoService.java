package service;

import dao.ConjuntoDAO;
import model.Conjunto;

public class ConjuntoService {
	ConjuntoDAO dao;
	
	public ConjuntoService()
	{
		dao = new ConjuntoDAO();
	}
	
	public void verificaOcupacao(Conjunto to)
	{
		dao.ocupado(to);
	}
	
	public void qtdAndares()
	{
		dao.andares();
	}
	
	public void excluirEmpresaDoConjunto(Conjunto to)
	{
		dao.excluiConj(to);
	}
	
	public void nomeEmpresaDoCOnjunto(Conjunto to)
	{
		dao.nomeEmpresa(to);
	}
	
	public void inserirEmpresa(Conjunto to, String cnpj)
	{
		dao.inserirEmpresa(to, cnpj);
	}
	
	public void conjuntosDaEmpresa(Conjunto to, String cnpj)
	{
		dao.conjEmpresa(cnpj);
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

}
