package org.sadpa.dto;

import java.util.List;

public class RegionalizacaoCreateDto
{
   private String nome;    
   private String descricao;  
   private EstadoCreateDto estado;   
   private List<RegiaoRegionalizacaoCreateDto> regiao;
   
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
}
