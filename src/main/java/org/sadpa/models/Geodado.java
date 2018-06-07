package org.sadpa.models;

import java.text.SimpleDateFormat;
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
	private Calendar dataHoraInsercao;
	private Calendar dataHoraModificacao;
	private String latitude;
	private String longitude;

	@ManyToOne
	@JoinColumn(name = "idInstituicaoFonte")
	private InstituicaoFonte instituicaoFonte;
	
	@ManyToOne
	@JoinColumn(name = "idItemCamada")
	private ItemCamada itemCamada;

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

	public String getDataHoraInsercao() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");				
		return formato.format(dataHoraInsercao.getTime());
	}

	public void setDataHoraInsercao(Calendar dataHoraInsercao) {
		this.dataHoraInsercao = dataHoraInsercao;
	}

	public String getDataHoraModificacao() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");				
		return formato.format(dataHoraModificacao.getTime());
	}

	public void setDataHoraModificacao(Calendar dataHoraModificacao) {
		this.dataHoraModificacao = dataHoraModificacao;
	}

	public void setInstituicaoFonte(InstituicaoFonte instituicaoFonte) {
		this.instituicaoFonte = instituicaoFonte;
	}

	public ItemCamada getItemCamada() {
		return itemCamada;
	}

	public void setItemCamada(ItemCamada itemCamada) {
		this.itemCamada = itemCamada;
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
	
}
