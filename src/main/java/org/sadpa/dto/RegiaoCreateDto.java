package org.sadpa.dto;

 
import java.util.List;
 

public class RegiaoCreateDto
{
	private String nome;
	private String descricao;
	private List<MunicipioCreateDto> municipios;
	
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
	public List<MunicipioCreateDto> getMunicipios() {
		return municipios;
	}
	public void setMunicipios(List<MunicipioCreateDto> municipios) {
		this.municipios = municipios;
	}
	 
 
}
