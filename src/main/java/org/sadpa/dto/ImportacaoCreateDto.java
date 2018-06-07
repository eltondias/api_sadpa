package org.sadpa.dto;

import java.util.List;
import java.util.Map;

 

public class ImportacaoCreateDto    {
	
	private Integer  idUsuario;		
	private Integer  idCamada;
	private Integer  idInstituicaoFonte;
	private Integer  idMunicipio;
	private List<Map<String, Object>> lista;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdCamada() {
		return idCamada;
	}
	public void setIdCamada(Integer idCamada) {
		this.idCamada = idCamada;
	}
	public Integer getIdInstituicaoFonte() {
		return idInstituicaoFonte;
	}
	public void setIdInstituicaoFonte(Integer idInstituicaoFonte) {
		this.idInstituicaoFonte = idInstituicaoFonte;
	}
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public List< Map<String, Object>> getLista() {
		return lista;
	}
	public void setLista(List< Map<String, Object>> lista) {
		this.lista = lista;
	}
}
