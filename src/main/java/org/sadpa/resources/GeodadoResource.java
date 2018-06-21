package org.sadpa.resources;

import javax.validation.Valid;

import org.sadpa.dto.DadosGeodadoDto;
import org.sadpa.dto.FiltroDados;
import org.sadpa.dto.GeoadadoMapDto;
import org.sadpa.dto.GeodadoReadDto;
import org.sadpa.dto.GeodadoUpdateDto;
import org.sadpa.models.Geodado;
import org.sadpa.services.GeodadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@RequestMapping("/geodado")
@Api(description = "Dados geolocalizados das camadas")
public class GeodadoResource {

	@Autowired
	private GeodadoService service;

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Obter geodados pela camada")
	@GetMapping(value = "/obterPorCamada/{idCamada}", produces = "application/json")
	public @ResponseBody Iterable<GeodadoReadDto> obterPorCamada(@PathVariable(value = "idCamada") int idCamada)
			throws Exception {
		return service.obterPorCamada(idCamada);
	}

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Obtem uma geodado pelo id")
	@GetMapping(value = "/{idGeodado}", produces = "application/json")
	public @ResponseBody Geodado obter(@PathVariable(value = "idGeodado") int idGeodado) throws Exception {
		return service.obter(idGeodado);
	}

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Atualiza geodado")
	@PutMapping(value = "/", produces = "application/json")
	public @ResponseBody GeodadoReadDto atualizar(@RequestBody @Valid GeodadoUpdateDto geodado) throws Exception {
		return service.atualizar(geodado);
	}
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Obtem coordenadas dos geodados")
	@PostMapping(value="/geodadoMap", produces="application/json")
	public @ResponseBody Iterable<GeoadadoMapDto> geodadoMap(@RequestBody FiltroDados filtroDados) throws Exception{		 	 
		return service.geodadoMap(filtroDados);
	}
	
	
	/*@CrossOrigin(origins = "*")
	@ApiOperation(value="Testes")
	@PostMapping(value="/teste", produces="application/json")
	public @ResponseBody Iterable<GeoadadoMapDto> teste(@RequestBody FiltroDados filtroDados) throws Exception{		 	 
		return service.geodadoMap(filtroDados);
	}*/
	
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Obtem dados da camada")
	@GetMapping(value="/dadosGeodado/{idGeodado}", produces="application/json")
	public @ResponseBody DadosGeodadoDto dadosGeodado(@PathVariable(value = "idGeodado") int idGeodado) throws Exception{		 	 
		return service.dadosGeodado(idGeodado);
	}
	

}
