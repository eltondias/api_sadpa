package org.sadpa.dto;


public class InstituicaoFonteUpdateDto {

	private Integer idInstituicaoFonte;
	
	private String nome;
	
	private String descricao;
	
	private String cnpj;
	
	private int situacao;

	public Integer getIdInstituicaoFonte() {
		return idInstituicaoFonte;
	}

	public void setIdInstituicaoFonte(Integer idInstituicaoFonte) {
		this.idInstituicaoFonte = idInstituicaoFonte;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

}
