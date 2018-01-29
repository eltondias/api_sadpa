package org.sadpa.dto;

import java.util.List;

public class CamadaUpdateDto  {
			 	 	 
	private int idCamada;
	private String nome;		 
	private String descricao;		 
	private List<CampoUpdateDto> campos;
	private int situacao;
	
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
	public List<CampoUpdateDto> getCampos() {
		return campos;
	}
	public void setCampos(List<CampoUpdateDto> campos) {
		this.campos = campos;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}	
}
