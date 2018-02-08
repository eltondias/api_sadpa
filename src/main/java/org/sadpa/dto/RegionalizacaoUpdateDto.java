package org.sadpa.dto;

import java.util.List;

public class RegionalizacaoUpdateDto
{
   private int idRegionalizacao;	
   private String nome;    
   private String descricao;  
   private EstadoCreateDto estado;   
   private List<RegiaoRegionalizacaoCreateDto> regiao;
   private int situacao;
   
	public int getIdRegionalizacao() {
		return idRegionalizacao;
	}
	public void setIdRegionalizacao(int idRegionalizacao) {
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
	public EstadoCreateDto getEstado() {
		return estado;
	}
	public void setEstado(EstadoCreateDto estado) {
		this.estado = estado;
	}
	public List<RegiaoRegionalizacaoCreateDto> getRegiao() {
		return regiao;
	}
	public void setRegiao(List<RegiaoRegionalizacaoCreateDto> regiao) {
		this.regiao = regiao;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	} 
}
