package org.sadpa.dto;

import org.sadpa.models.TipoCampo;

public class CampoDto{
		 
	private int idCampo;	
	private boolean obrigatorio;	
	private boolean titulo;		
	private String nome;
    private int camada;	
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
	public int getCamada() {
		return camada;
	}
	public void setCamada(int camada) {
		this.camada = camada;
	}
	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}
	public void setTipoCampo(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}
	
	
	 
}