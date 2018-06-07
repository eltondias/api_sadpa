package org.sadpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SessaoCnae
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSessao;
	private String codigo;
	private String denominacao;
	private Boolean situacao;
	@ManyToOne
	@JoinColumn(name = "idVersao")
    private VersaoCnae versaoCnae;
	
	public Integer getIdSessao() {
		return idSessao;
	}
	public void setIdSessao(Integer idSessao) {
		this.idSessao = idSessao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDenominacao() {
		return denominacao;
	}
	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}
	public Boolean getSituacao() {
		return situacao;
	}
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	public VersaoCnae getVersaoCnae() {
		return versaoCnae;
	}
	public void setVersaoCnae(VersaoCnae versaoCnae) {
		this.versaoCnae = versaoCnae;
	}
}
