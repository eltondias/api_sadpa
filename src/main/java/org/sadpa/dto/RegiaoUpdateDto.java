package org.sadpa.dto;

 
import java.util.List;
import org.sadpa.models.Municipio;
 

public class RegiaoUpdateDto
{
	private Integer idRegiao;
	private String nome;
	private String descricao;
	private int situacao;
	private List<Municipio> municipios;
	
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
}
