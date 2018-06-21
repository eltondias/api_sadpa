package org.sadpa.dto;


import org.sadpa.dto.ValorCampoReadDto;

import java.util.ArrayList;
import java.util.List;

import org.sadpa.dto.GeodadoReadDto;


public class DadosGeodadoDto {

	private GeodadoReadDto geodado;
	
	private List<ValorCampoReadDto> valorCampos =  new ArrayList<ValorCampoReadDto>();

	public GeodadoReadDto getGeodado() {
		return geodado;
	}

	public void setGeodado(GeodadoReadDto geodado) {
		this.geodado = geodado;
	}

	public List<ValorCampoReadDto> getValorCampos() {
		return valorCampos;
	}

	public void setValorCampos(List<ValorCampoReadDto> valorCampos) {
		this.valorCampos = valorCampos;
	}

	 
	 

}
