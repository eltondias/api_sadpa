package org.sadpa.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.rest.core.annotation.Description;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Regiao
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegiao;
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private Calendar dataHoraInsercao;	
	private Calendar dataHoraAtualizacao;	
	private Calendar dataHoraExclusao;	
	@Description("0 - INATIVA, 1 - ATIVA, 2 - BLOQUEADA, 3 - EXCLUIDA")
	private int situacao;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	@JoinTable(name = "municipio_regiao", 
	           joinColumns = { @JoinColumn(name = "idRegiao") }, 
	           inverseJoinColumns = { @JoinColumn(name = "idMunicipio") })
	private List<Municipio> municipios;
	
   @ManyToMany
   @JoinTable(name = "regionalizacao_regiao", 
              joinColumns = { @JoinColumn(name = "idRegiao") }, 
              inverseJoinColumns = { @JoinColumn(name = "idRegionalizacao") })
   @JsonIgnore
   private List<Regionalizacao> regionalizacoes;

	public Integer getIdRegiao() {
		return idRegiao;
	}
	
	public void setIdRegiao(Integer idRegiao) {
		this.idRegiao = idRegiao;
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
	
	public List<Municipio> getMunicipios() {
		return municipios;
	}
	
	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	
	public List<Regionalizacao> getRegionalizacoes() {
		return regionalizacoes;
	}
	
	public void setRegionalizacoes(List<Regionalizacao> regionalizacoes) {
		this.regionalizacoes = regionalizacoes;
	}
}
