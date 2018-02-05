package org.sadpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import java.util.List;

@Entity
public class Regionalizacao
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idRegionalizacao;
   private String nome;
   
   @ManyToOne
   @JoinColumn(name = "idEstado")
   private Estado estado;
   
   @LazyCollection(LazyCollectionOption.FALSE)
   @ManyToMany
   @JoinTable(joinColumns = { @JoinColumn(name = "idRegionalizacao") }, inverseJoinColumns = { @JoinColumn(name = "idRegiao") })
   private List<Regiao> regiao;

	public Integer getIdRegionalizacao() {
		return idRegionalizacao;
	}
	
	public void setIdRegionalizacao(Integer idRegionalizacao) {
		this.idRegionalizacao = idRegionalizacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
