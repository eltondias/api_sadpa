package org.sadpa.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

 

public class CamadaCreateDto extends ResourceSupport{
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 
	private int idCamada;	 
	private String nome;		 
	private String descricao;		 
	private Calendar dataHoraInsercao;
	private boolean situacao;	
	private List<CampoDto> campos;
		 
	public List<CampoDto> getCampos() {
		return campos;
	}
	public void setCampos(List<CampoDto> campos) {
		this.campos = campos;
	}
	public int getIdCamada() {
		return idCamada;
	}
	public void setIdCamada(int idCamada) {
		this.idCamada = idCamada;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataHoraInsercao() {		 		
		return dateFormat.format(dataHoraInsercao.getTime());
	}
	public void setDataHoraInsercao(Calendar dataHoraInsercao) {
		this.dataHoraInsercao = dataHoraInsercao;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
}
