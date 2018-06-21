package org.sadpa.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.annotation.Description;

@Entity
public class ValorCampo
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idValorCampo;	
	private Calendar dataHoraInsercao;	
	private Calendar dataHoraAtualizacao;	
	private Calendar dataHoraExclusao;
	@Description("0 - INATIVO, 1 - ATIVO,  2 - EXCLUIDO")
	private int situacao;
	
	@Column(columnDefinition = "TEXT")
	private String valor;
	
	@ManyToOne
	@JoinColumn(name = "idCampo")
	private Campo campo;
	
	@ManyToOne
	@JoinColumn(name = "idGeodado")
	private Geodado geodado;

	public Integer getIdValorCampo() {
		return idValorCampo;
	}

	public void setIdValorCampo(Integer idValorCampo) {
		this.idValorCampo = idValorCampo;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Geodado getGeodado() {
		return geodado;
	}

	public void setGeodado(Geodado geodado) {
		this.geodado = geodado;
	}
	
	
}
