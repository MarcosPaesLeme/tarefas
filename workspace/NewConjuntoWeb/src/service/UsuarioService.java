package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	UsuarioDAO dao;
	
	public UsuarioService ()
	{
		dao = new UsuarioDAO();
	}
	
	public Usuario consultarUsuario(Usuario to)
	{
		return dao.consultarUsuario(to);
	}
	
	public boolean validaUsuario(Usuario to)
	{
		return dao.validarUsuario(to);
	}
}
