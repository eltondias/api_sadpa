package org.sadpa.dto;

import java.util.List;

public class UsuarioReadDto
{	 
	private int idUsuario;
	private String login;	
	private String senha;
	private String email;	
	private Boolean admin;
	private int situacao;
	private List<CamadaUsuarioDto> camadas;
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
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
		this.senha = senha;
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
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public List<CamadaUsuarioDto> getCamadas() {
		return camadas;
	}
	public void setCamadas(List<CamadaUsuarioDto> camadas) {
		this.camadas = camadas;
	}
	 
  
	 
}

