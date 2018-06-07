package org.sadpa.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemCamada
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idItemCamada;
   
   @ManyToOne
   @JoinColumn(name = "idCamada")
   private Camada camada;

	public Integer getIditemCamada() {
		return idItemCamada;
	}
	
	public void setIditemCamada(Integer idItemCamada) {
		this.idItemCamada = idItemCamada;
	}
	
	public Camada getCamada() {
		return camada;
	}
	
	public void setCamada(Camada camada) {
		this.camada = camada;
	}
   
   
}
