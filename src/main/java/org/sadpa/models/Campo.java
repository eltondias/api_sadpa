package org.sadpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Campo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCampo;
	private boolean obrigatorio;
	private boolean titulo;	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "idCamada")
    private Camada camada;
	
	@ManyToOne
	@JoinColumn(name = "idTipoCampo")
	private TipoCampo tipoCampo;

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

	public Camada getCamada() {
		return camada;
	}

	public void setCamada(Camada camada) {
		this.camada = camada;
	}

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}
	
	
		
}