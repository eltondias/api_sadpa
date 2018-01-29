package org.sadpa.dto;

public class CampoReadDto{
		 
	private int idCampo;	
	private boolean obrigatorio;	
	private boolean titulo;		
	private String nome;

	private TipoCampoReadDto tipoCampo;
	
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
	 
	public TipoCampoReadDto getTipoCampo() {
		return tipoCampo;
	}
	public void setTipoCampo(TipoCampoReadDto tipoCampo) {
		this.tipoCampo = tipoCampo;
	}
	
	
	 
}