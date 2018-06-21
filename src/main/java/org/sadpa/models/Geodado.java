package org.sadpa.models;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Geodado
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGeodado;	
	private String latitude;
	private String longitude;
	private Calendar dataHoraInsercao;	
	private Calendar dataHoraAtualizacao;	
	private Calendar dataHoraExclusao;
	
	
	@ManyToOne
	@JoinColumn(name = "idCamada")
	private Camada camada;
	

	@ManyToOne
	@JoinColumn(name = "idInstituicaoFonte")
	private InstituicaoFonte instituicaoFonte;
	

	@ManyToOne
	@JoinColumn(name = "idMunicipio")
	private Municipio municipio;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idLoteImportacao")
	private LoteImportacao loteImportacao;

	@ManyToOne
	@JoinColumn(name = "idAtividadeEconomica")
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

	public Camada getCamada() {
		return camada;
	}

	public void setCamada(Camada camada) {
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

	public AtividadeEconomica getAtividadeEconomica() {
		return atividadeEconomica;
	}

	public void setAtividadeEconomica(AtividadeEconomica atividadeEconomica) {
		this.atividadeEconomica = atividadeEconomica;
	}
}
