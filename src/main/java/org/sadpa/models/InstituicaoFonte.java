package org.sadpa.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.sadpa.utils.Formata;
import org.springframework.data.rest.core.annotation.Description;

@Entity
public class InstituicaoFonte
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInstituicaoFonte;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@NotBlank
	private String cnpj;

	@Description("0 - INATIVA, 1 - ATIVA, 2 - BLOQUEADA, 3 - EXCLUIDA")
	private int situacao;
	
	private Calendar dataHoraInsercao;
	
	private Calendar dataHoraAtualizacao;
	
	private Calendar dataHoraExclusao;

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
		this.cnpj = cnpj.replace(".", "").replace("-", "").replace("/", "");
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public String getDataHoraInsercao() {
		return Formata.DataTime(dataHoraInsercao);
	}

	public void setDataHoraInsercao(Calendar dataHoraInsercao) {
		this.dataHoraInsercao = dataHoraInsercao;
	}

	public String getDataHoraAtualizacao() {
		return  Formata.DataTime(dataHoraAtualizacao);
	}

	public void setDataHoraAtualizacao(Calendar dataHoraAtualizacao) {
		this.dataHoraAtualizacao = dataHoraAtualizacao;
	}

	public String getDataHoraExclusao() {
		return Formata.DataTime(dataHoraExclusao);
	}

	public void setDataHoraExclusao(Calendar dataHoraExclusao) {
		this.dataHoraExclusao = dataHoraExclusao;
	}
}
