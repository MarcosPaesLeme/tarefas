package service;

import dao.ConjuntoDAO;

import model.Conjunto;

public class ConjuntoService 
{
	ConjuntoDAO dao = new ConjuntoDAO();
	
	public void criar(Conjunto conjunto)
	{
		dao.criar(conjunto);
	}
	
	public void atualizar(Conjunto conjunto)
	{
		dao.atualizar(conjunto);
	}
	
	public void excluir(int id)
	{
		dao.excluir(id);
	}
	
	public Conjunto carregar(int id)
	{
		return dao.carregar(id);
	}
	
	public int retornaUltimoId(Conjunto conjunto)
	{
		return dao.retornaUltimoId(conjunto);
	}
}
