package org.sadpa.dto;

import java.util.Calendar;
import java.util.List;

public class FiltroDados {

	private List<Integer> camadas;
	private List<Integer> regionalizacoes;
    private List<Integer> regioes;
    private List<Integer> municipios;
    private Calendar dataInicial;
    private Calendar dataFinal;
    
	public List<Integer> getCamadas() {
		return camadas;
	}
	public void setCamadas(List<Integer> camadas) {
		this.camadas = camadas;
	}
	public List<Integer> getRegionalizacoes() {
		return regionalizacoes;
	}
	public void setRegionalizacoes(List<Integer> regionalizacoes) {
		this.regionalizacoes = regionalizacoes;
	}
	public List<Integer> getRegioes() {
		return regioes;
	}
	public void setRegioes(List<Integer> regioes) {
		this.regioes = regioes;
	}
	public List<Integer> getMunicipios() {
		return municipios;
	}
	public void setMunicipios(List<Integer> municipios) {
		this.municipios = municipios;
	}
	public Calendar getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Calendar getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}

}
