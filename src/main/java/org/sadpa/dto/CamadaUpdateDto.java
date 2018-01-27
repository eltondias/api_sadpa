package org.sadpa.dto;

import java.util.List;
public class CamadaUpdateDto {
			 
	private int idCamada;	 
	private String nome;		 
	private String descricao;		 	 
	private boolean situacao;	
	
	private List<CampoDto> campos;
		 
	public List<CampoDto> getCampos() {
		return campos;
	}
	public void setCampos(List<CampoDto> campos) {
		this.campos = campos;
	}
	public int getIdCamada() {
		return idCamada;
	}
	public void setIdCamada(int idCamada) {
		this.idCamada = idCamada;
	}
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
 
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
}
