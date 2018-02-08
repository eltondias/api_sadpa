package org.sadpa.dto;

import org.sadpa.utils.Criptografia;

public class UsuarioCreateDto
{	 
	private String login;	
	private String senha;
	private String email;	
	private Boolean admin;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = Criptografia.Cripto(senha);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}	
}

