package org.sadpa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Regiao
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegiao;
	private String nome;

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
