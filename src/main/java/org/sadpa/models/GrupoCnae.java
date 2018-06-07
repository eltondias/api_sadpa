package org.sadpa.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class GrupoCnae
{

	@Id
	private String idGrupo;
	private String mascara;
	private String denominacao;
	
	@ManyToOne
	@JoinColumn(name = "idDivisao")
    private DivisaoCnae divisaoCnae;
	
	private Boolean situacao;

	public String getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
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

	public DivisaoCnae getDivisaoCnae() {
		return divisaoCnae;
	}

	public void setDivisaoCnae(DivisaoCnae divisaoCnae) {
		this.divisaoCnae = divisaoCnae;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	
	
	
}
