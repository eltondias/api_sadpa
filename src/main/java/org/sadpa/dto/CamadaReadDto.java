package org.sadpa.dto;

import java.util.Calendar;
import java.util.List;

import org.sadpa.utils.Formata;
import org.springframework.hateoas.ResourceSupport;


public class CamadaReadDto  extends ResourceSupport {
	
	private int idCamada;
	private String nome;		 
	private String descricao;		 
	private List<CampoReadDto> campos;
	private Calendar dataHoraInsercao;
	private Calendar dataHoraAtualizacao;
	private Calendar dataHoraExclusao;
	private int situacao;	

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
	public List<CampoReadDto> getCampos() {
		return campos;
	}
	public void setCampos(List<CampoReadDto> campos) {
		this.campos = campos;
	}	
	
	public int getIdCamada() {
		return idCamada;
	}

	public void setIdCamada(int idCamada) {
		this.idCamada = idCamada;
	}	
	
	public String getDataHoraInsercao() {			 
		return Formata.DataTime(dataHoraInsercao);
	}
	public void setDataHoraInsercao(Calendar dataHoraInsercao) {
		this.dataHoraInsercao = dataHoraInsercao;
	}

	public String getDataHoraAtualizacao() {		 	
		return Formata.DataTime(dataHoraAtualizacao);		
	}
	
	public void setDataHoraAtualizacao(Calendar dataHoraAtualizacao) {
		this.dataHoraAtualizacao = dataHoraAtualizacao;
	}
	
	public String  getDataHoraExclusao() {
		return Formata.DataTime(dataHoraExclusao);
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
