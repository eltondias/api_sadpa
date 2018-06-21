package org.sadpa.dto;

public class GeoadadoMapDto {
	
	private Integer idGeodado;	
	private CamadaReadDto camada;
	private String latitude;
	private String longitude;				
	 
	public CamadaReadDto getCamada() {
		return camada;
	}
	public void setCamada(CamadaReadDto camada) {
		this.camada = camada;
	}
	public Integer getIdGeodado() {
		return idGeodado;
	}
	public void setIdGeodado(Integer idGeodado) {
		this.idGeodado = idGeodado;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	

}
