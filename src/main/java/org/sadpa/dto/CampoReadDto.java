package org.sadpa.dto;

import java.util.Calendar;

import org.sadpa.utils.Formata;

public class CampoReadDto{
		 
	private int idCampo;	
	private boolean obrigatorio;	
	private boolean titulo;		
	private String nome;
	private int situacao;  
	private TipoCampoReadDto tipoCampo;
	private Calendar dataHoraExclusao;
	
	public String getDataHoraExclusao() {
		return Formata.DataTime(this.dataHoraExclusao);
		
	}
	public void setDataHoraExclusao(Calendar dataHoraExclusao) {
		this.dataHoraExclusao = dataHoraExclusao;
	}
	public int getIdCampo() {
		return idCampo;
	}
	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}
	public boolean isObrigatorio() {
		return obrigatorio;
	}
	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	public boolean isTitulo() {
		return titulo;
	}
	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public TipoCampoReadDto getTipoCampo() {
		return tipoCampo;
	}
	public void setTipoCampo(TipoCampoReadDto tipoCampo) {
		this.tipoCampo = tipoCampo;
	}
	
}