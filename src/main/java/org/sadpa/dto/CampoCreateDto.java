package org.sadpa.dto;

import org.sadpa.dto.TipoCampoCreateDto;


public class CampoCreateDto {
	
	private String nome;
	private boolean titulo;	
	private boolean obrigatorio;				
	private int situacao;  
	private TipoCampoCreateDto tipoCampo;
	
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
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public TipoCampoCreateDto getTipoCampo() {
		return tipoCampo;
	}
	public void setTipoCampo(TipoCampoCreateDto tipoCampo) {
		this.tipoCampo = tipoCampo;
	}	
}