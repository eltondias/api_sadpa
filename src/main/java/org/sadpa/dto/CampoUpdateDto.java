package org.sadpa.dto;

import org.sadpa.models.TipoCampo;

public class CampoUpdateDto{
		 
	private int idCampo;	
	private boolean obrigatorio;	
	private boolean titulo;		
	private String nome;
	private int situacao;  
	private TipoCampo tipoCampo;
	
	public int getIdCampo() {
		return idCampo;
	}
	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}
	public boolean isObrigatorio() {
		return obrigatorio;
	}
	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	public boolean isTitulo() {
		return titulo;
	}
	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}
	public void setTipoCampo(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}	
}