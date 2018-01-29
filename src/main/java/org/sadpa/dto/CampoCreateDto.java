package org.sadpa.dto;

import org.sadpa.dto.TipoCampoCreateDto;


public class CampoCreateDto {
	
	//private int idCampo;	
	private String nome;
	private boolean titulo;	
	private boolean obrigatorio;				
	private TipoCampoCreateDto tipoCampo;	
	
	/*public int getIdCampo() {
		return idCampo;
	}
	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isTitulo() {
		return titulo;
	}
	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}
	public boolean isObrigatorio() {
		return obrigatorio;
	}
	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	public TipoCampoCreateDto getTipoCampo() {
		return tipoCampo;
	}
	public void setTipoCampo(TipoCampoCreateDto tipoCampo) {
		this.tipoCampo = tipoCampo;
	}
}