package org.sadpa.models;

public class SituacaoCamada {
	
	private int idSituacao; 
	private String descricao;
	
	public SituacaoCamada(int codigo, String descricao){
		this.setIdSituacao(codigo);
		this.setDescricao(descricao);
	}

	public int getIdSituacao() {
		return idSituacao;
	}

	public void setIdSituacao(int idSituacao) {
		this.idSituacao = idSituacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
} 
