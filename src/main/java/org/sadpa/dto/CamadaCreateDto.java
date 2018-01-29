package org.sadpa.dto;

import java.util.List;

public class CamadaCreateDto    {
	
	private String nome;		 
	private String descricao;		 
	private List<CampoCreateDto> campos;
		 
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
}
