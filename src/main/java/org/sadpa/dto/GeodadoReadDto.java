package org.sadpa.dto;

import java.util.Calendar;
import org.sadpa.models.AtividadeEconomica;
import org.sadpa.models.InstituicaoFonte;
import org.sadpa.models.Municipio;
import org.sadpa.utils.Formata;

public class GeodadoReadDto {

	private Integer idGeodado;	
	private String latitude;
	private String longitude;
	private Calendar dataHoraInsercao;	
	private CamadaReadDto camada;
	private InstituicaoFonte instituicaoFonte;	
	private Municipio municipio;	
	//private Usuario usuario;
	//private LoteImportacao loteImportacao;	
	private AtividadeEconomica atividadeEconomica;
	
	public Integer getIdGeodado() {
		return idGeodado;
	}
	public void setIdGeodado(Integer idGeodado) {
		this.idGeodado = idGeodado;
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
	
	public String getDataHoraInsercao() {
		return  Formata.DataTime(dataHoraInsercao);
	}
	
	public void setDataHoraInsercao(Calendar dataHoraInsercao) {
		this.dataHoraInsercao = dataHoraInsercao;
	}
	
	public CamadaReadDto getCamada() {
		return camada;
	}
	public void setCamada(CamadaReadDto camada) {
		this.camada = camada;
	}
	
	public InstituicaoFonte getInstituicaoFonte() {
		return instituicaoFonte;
	}
	public void setInstituicaoFonte(InstituicaoFonte instituicaoFonte) {
		this.instituicaoFonte = instituicaoFonte;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	/*
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public LoteImportacao getLoteImportacao() {
		return loteImportacao;
	}
	public void setLoteImportacao(LoteImportacao loteImportacao) {
		this.loteImportacao = loteImportacao;
	}
	*/
	public AtividadeEconomica getAtividadeEconomica() {
		return atividadeEconomica;
	}
	public void setAtividadeEconomica(AtividadeEconomica atividadeEconomica) {
		this.atividadeEconomica = atividadeEconomica;
	}
	
}
