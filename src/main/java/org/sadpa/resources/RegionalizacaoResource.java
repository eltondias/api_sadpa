package org.sadpa.resources;
import javax.validation.Valid;

import org.sadpa.dto.CamadaCreateDto;
import org.sadpa.dto.CamadaReadDto;
import org.sadpa.dto.CamadaUpdateDto;
import org.sadpa.services.CamadaService;
import org.sadpa.services.RegionalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/regionalizacao")
@Api(description = "Regionalização")
public class RegionalizacaoResource {

	@Autowired
	private RegionalizacaoService service;
		

	/*
	@ApiOperation(value="Cadastra uma nova camada e seus campos")
	@PostMapping()
	public CamadaReadDto cadastrarCamada(@RequestBody @Valid CamadaCreateDto camada) throws Exception{								
		return service.cadastrarRegionalizacao(camada);
	}
	
	
	@ApiOperation(value="Obtem uma camada pelo id da camada")
	@GetMapping(value="/{idCamada}", produces="application/json")
	public @ResponseBody CamadaReadDto obterCamada(@PathVariable(value="idCamada") int idCamada) throws Exception{		 	 
		return service.obterCamada(idCamada);
	}
		
	@ApiOperation(value="Atualiza uma camada")
	@PutMapping(value="/", produces="application/json")
	public @ResponseBody CamadaReadDto  atualizarCamada(@RequestBody @Valid CamadaUpdateDto camadaUpdateDto) throws Exception{			
		return service.atualizarCamada(camadaUpdateDto);
	}
	
	
	@ApiOperation(value="Excluir uma camada")
	@DeleteMapping(value="/", produces="application/json")
	public @ResponseBody CamadaReadDto  excluirCamada(@RequestParam(value="idCamada") int idCamada) throws Exception{			
		return service.excluirCamada(idCamada);
	}
	
	
	@ApiOperation(value="Lista camadas por situação (0 - INATIVA, 1 - ATIVA, 2 - BLOQUEADA, 3 - EXCLUIDA)")
	@GetMapping(value="/PorSituacao/{situacao}", produces="application/json")
	public @ResponseBody Iterable<CamadaReadDto> listarCamadasPorSituacao(@PathVariable(value="situacao") int situacao) throws Exception {			 
		return service.listarCamadasPorSituacao(situacao);		
	}	
	
	@ApiOperation(value="Lista com todas as camadas")
	@GetMapping(value = "/", produces = "application/json; charset=UTF-8")
	public @ResponseBody Iterable<CamadaReadDto> listarTodasCamadas() throws Exception {			 
		return service.listarTodasCamadas();		
	}	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
