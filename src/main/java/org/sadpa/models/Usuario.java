package org.sadpa.models;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany; 
 
 
@Entity
public class Usuario
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String login;	
	private String senha;
	private String email;	
	private Boolean admin;
	private int situacao;
	private Calendar dataHoraInsercao;
	private Calendar dataHoraAtualizacao;
	private Calendar dataHoraExclusao;
	
	 @ManyToMany
	 @JoinTable(name = "camada_usuario", 
	              joinColumns = { @JoinColumn(name = "idUsuario") }, 
	              inverseJoinColumns = { @JoinColumn(name = "idCamada") })
	// @JsonIgnore
	 private List<Camada> camadas;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
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

	public Calendar getDataHoraInsercao() {
		return dataHoraInsercao;
	}

	public void setDataHoraInsercao(Calendar dataHoraInsercao) {
		this.dataHoraInsercao = dataHoraInsercao;
	}

	public Calendar getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}

	public void setDataHoraAtualizacao(Calendar dataHoraAtualizacao) {
		this.dataHoraAtualizacao = dataHoraAtualizacao;
	}

	public Calendar getDataHoraExclusao() {
		return dataHoraExclusao;
	}

	public void setDataHoraExclusao(Calendar dataHoraExclusao) {
		this.dataHoraExclusao = dataHoraExclusao;
	}

	public List<Camada> getCamadas() {
		return camadas;
	}

	public void setCamadas(List<Camada> camadas) {
		this.camadas = camadas;
	}

	
}

