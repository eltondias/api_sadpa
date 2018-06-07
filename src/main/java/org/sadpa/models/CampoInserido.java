package org.sadpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CampoInserido
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCampoInserido;
	private Boolean ativo;
	
	@Column(columnDefinition = "TEXT")
	private String valor;
	
	@ManyToOne
	@JoinColumn(name = "idCampo")
	private Campo campo;
	
	@ManyToOne
	@JoinColumn(name = "idItemCamada")
	private ItemCamada Item;
	
	public Integer getIdCampoInserido() {
		return idCampoInserido;
	}
	
	public void setIdCampoInserido(Integer idCampoInserido) {
		this.idCampoInserido = idCampoInserido;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public Campo getCampo(){
		return campo;
	}
	
	public void setCampo(Campo campo){
		this.campo = campo;
	}
	
	public ItemCamada getItemCamada(){
		return Item;
	}
	
	public void setItemCamada(ItemCamada item){
		this.Item = item;
	}
	
}
