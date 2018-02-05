package org.sadpa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Municipio
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idMunicipio;
   private String nome;
   @ManyToOne
   @JoinColumn(name = "idEstado")
   private Estado estado;
   private String latitude;
   private String longitude;
   
  
   
   @ManyToMany
   @JoinTable(joinColumns = { @JoinColumn(name = "idMunicipio") }, inverseJoinColumns = { @JoinColumn(name = "idRegiao") })
   @JsonIgnore
   private List<Regiao> regiao;

   
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Regiao> getRegiao() {
		return regiao;
	}
	
	public void setRegiao(List<Regiao> regiao) {
		this.regiao = regiao;
	}
   
}