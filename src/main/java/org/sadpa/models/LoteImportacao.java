package org.sadpa.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LoteImportacao
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLoteImportacao;
	private Calendar dataHora;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	private Integer status;
	
	public Integer getIdLoteImportacao() {
		return idLoteImportacao;
	}
	public void setIdLoteImportacao(Integer idLoteImportacao) {
		this.idLoteImportacao = idLoteImportacao;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
