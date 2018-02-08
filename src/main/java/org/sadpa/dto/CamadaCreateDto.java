package org.sadpa.dto;

import java.util.List;

public class CamadaCreateDto    {
	
	private String nome;		 
	private String descricao;		 
	private List<CampoCreateDto> campos;
	private List<UsuarioCamadaCreateDto> usuarios;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<CampoCreateDto> getCampos() {
		return campos;
	}
	public void setCampos(List<CampoCreateDto> campos) {
		this.campos = campos;
	}
	public List<UsuarioCamadaCreateDto> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioCamadaCreateDto> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	 

}
