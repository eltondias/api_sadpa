package org.sadpa.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AtividadeEconomica
{

	@Id
	private String idAtividadeEconomica;
	private String mascara;
	private String denominacao;
	private Boolean situacao;
	
	
	
	@ManyToOne
	@JoinColumn(name = "idVersao")
    private VersaoCnae versaoCnae;
	
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(name = "idClasse")
    private ClasseCnae classeCnae;

	public String getIdAtividadeEconomica() {
		return idAtividadeEconomica;
	}

	public void setIdAtividadeEconomica(String idAtividadeEconomica) {
		this.idAtividadeEconomica = idAtividadeEconomica;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public ClasseCnae getClasseCnae() {
		return classeCnae;
	}

	public void setClasseCnae(ClasseCnae classeCnae) {
		this.classeCnae = classeCnae;
	}
}
