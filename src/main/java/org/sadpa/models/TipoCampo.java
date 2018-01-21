package org.sadpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoCampo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoCampo;
	private String nome;
	
	public int getIdTipoCampo() {
		return idTipoCampo;
	}
	public void setIdTipoCampo(int idTipoCampo) {
		this.idTipoCampo = idTipoCampo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
