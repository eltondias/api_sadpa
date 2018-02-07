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
import org.springframework.data.rest.core.annotation.Description;

import java.util.Calendar;
import java.util.List;

@Entity
public class Regionalizacao
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idRegionalizacao;
   private String nome;
   private String descricao; 
   private Calendar dataHoraInsercao;	
   private Calendar dataHoraAtualizacao;	
   private Calendar dataHoraExclusao;	
   @Description("0 - INATIVA, 1 - ATIVA, 2 - BLOQUEADA, 3 - EXCLUIDA")
   private int situacao;
   
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
