package org.sadpa.dto;

 
import java.util.List;
import org.sadpa.models.Municipio;
 

public class RegiaoCreateDto
{
	private String nome;
	private String descricao;
	private List<Municipio> municipios;
	
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
	public List<Municipio> getMunicipios() {
		return municipios;
	}
	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	 
 
}
