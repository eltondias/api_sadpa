package org.sadpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class DivisaoCnae
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDivisao;
	private String mascara;
	private String denominacao;	
	@ManyToOne
	@JoinColumn(name = "idSessao")
    private SessaoCnae sessaoCnae;	
	private Boolean situacao;
	
	public Integer getIdDivisao() {
		return idDivisao;
	}
	public void setIdDivisao(Integer idDivisao) {
		this.idDivisao = idDivisao;
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
	public SessaoCnae getSessaoCnae() {
		return sessaoCnae;
	}
	public void setSessaoCnae(SessaoCnae sessaoCnae) {
		this.sessaoCnae = sessaoCnae;
	}
	public Boolean getSituacao() {
		return situacao;
	}
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

}
