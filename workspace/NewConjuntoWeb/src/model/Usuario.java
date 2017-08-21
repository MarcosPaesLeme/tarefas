package model;

import java.io.Serializable;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_Login;
	private String username;
	private String password;
	
	public Usuario(){
	
	}
	
	public Usuario(int login, String username, String password) {
		super();
		this.id_Login = login;
		this.username = username;
		this.password = password;
	}
	
	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	
	public int getId_Login() {
		return id_Login;
	}

	public void setId_Login(int id_Login) {
		this.id_Login = id_Login;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
	