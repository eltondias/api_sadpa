package org.sadpa.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 

@Entity
public class ClasseCnae
{

	@Id
	private String idClasse;
	private String mascara;
	private String denominacao;
	
	@ManyToOne
	@JoinColumn(name = "idGrupo")
    private GrupoCnae grupoCnae;
	
	private Boolean situacao;

	public String getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(String idClasse) {
		this.idClasse = idClasse;
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

	public GrupoCnae getGrupoCnae() {
		return grupoCnae;
	}

	public void setGrupoCnae(GrupoCnae grupoCnae) {
		this.grupoCnae = grupoCnae;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	
	
	
}
