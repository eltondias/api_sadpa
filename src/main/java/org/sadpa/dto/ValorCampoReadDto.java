package org.sadpa.dto;

 
public class ValorCampoReadDto {
	
	private Integer idValorCampo;	
	private int situacao;
	private String valor;
	private CampoReadDto campo;
	
	public Integer getIdValorCampo() {
		return idValorCampo;
	}
	public void setIdValorCampo(Integer idValorCampo) {
		this.idValorCampo = idValorCampo;
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
	public CampoReadDto getCampo() {
		return campo;
	}
	public void setCampo(CampoReadDto campo) {
		this.campo = campo;
	}
	 
}
