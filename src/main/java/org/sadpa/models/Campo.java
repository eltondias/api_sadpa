package org.sadpa.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Campo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCampo;
	
	private boolean obrigatorio;
	
	private boolean titulo;	

	private Calendar dataHoraInsercao;
	
	private Calendar dataHoraAtualizacao;
	
	private Calendar dataHoraExclusao;
	
	private int situacao; //0 - INATIVO, 1 - ATIVO, 2 - BLOQUEADO, 3 - EXCLUIDO
			
	@NotBlank
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "idCamada")
    private Camada camada;
	
	@ManyToOne
	@JoinColumn(name = "idTipoCampo")
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Camada getCamada() {
		return camada;
	}

	public void setCamada(Camada camada) {
		this.camada = camada;
	}

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}	 
}