package org.sadpa.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CamadaDto_off {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 
	private int idCamada;	 
	private String nome;		 
	private String descricao;		 
	private Calendar dataHoraInsercao;
	private boolean situacao;
	
	public long getIdCamada() {
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
