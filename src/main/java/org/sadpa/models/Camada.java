package org.sadpa.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.rest.core.annotation.Description;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Camada  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCamada;
 
	@NotBlank
	private String nome;
	
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String descricao;
		
	private Calendar dataHoraInsercao;
	
	private Calendar dataHoraAtualizacao;
	
	private Calendar dataHoraExclusao;
	
	@Description("0 - INATIVA, 1 - ATIVA, 2 - BLOQUEADA, 3 - EXCLUIDA")
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

	public Calendar getDataHoraInsercao() {
		return dataHoraInsercao;
	}

	public void setDataHoraInsercao(Calendar dataHoraInsercao) {
		this.dataHoraInsercao = dataHoraInsercao;
	}

	public Calendar getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}

	public void setDataHoraAtualizacao(Calendar dataHoraAtualizacao) {
		this.dataHoraAtualizacao = dataHoraAtualizacao;
	}
	
	public Calendar getDataHoraExclusao() {
		return dataHoraExclusao;
	}

	public void setDataHoraExclusao(Calendar dataHoraExclusao) {
		this.dataHoraExclusao = dataHoraExclusao;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	
	
	
}
