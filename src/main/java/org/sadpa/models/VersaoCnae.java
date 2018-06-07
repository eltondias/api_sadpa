package org.sadpa.models;

 
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 

@Entity
public class VersaoCnae
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVersao;
	private String versao;
	private String título;
	private String abreviacao;
	private String baseLegal;
	private Calendar dataVersao;
	private Boolean situacao;
	
	
	public Integer getIdVersao() {
		return idVersao;
	}
	public void setIdVersao(Integer idVersao) {
		this.idVersao = idVersao;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getTítulo() {
		return título;
	}
	public void setTítulo(String título) {
		this.título = título;
	}
	public String getAbreviacao() {
		return abreviacao;
	}
	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}
	public String getBaseLegal() {
		return baseLegal;
	}
	public void setBaseLegal(String baseLegal) {
		this.baseLegal = baseLegal;
	}
	public Calendar getDataVersao() {
		return dataVersao;
	}
	public void setDataVersao(Calendar dataVersao) {
		this.dataVersao = dataVersao;
	}
	public Boolean getSituacao() {
		return situacao;
	}
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	
}
