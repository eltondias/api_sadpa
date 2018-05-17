package org.sadpa.resources;
import javax.validation.Valid;

import org.sadpa.dto.CamadaCreateDto;
import org.sadpa.dto.CamadaReadDto;
import org.sadpa.dto.CamadaUpdateDto;
import org.sadpa.models.SituacaoCamada;
import org.sadpa.services.CamadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@RequestMapping("/camada")
@Api(description = "Camadas de dados geolocalizados")
public class CamadaResource {

	@Autowired
	private CamadaService service;
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Cadastra uma nova camada e seus campos")
	@PostMapping()
	public CamadaReadDto cadastrar(@RequestBody @Valid CamadaCreateDto camada) throws Exception{								
		return service.cadastrar(camada);
	}
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Obtem uma camada pelo id da camada")
	@GetMapping(value="/{idCamada}", produces="application/json")
	public @ResponseBody CamadaReadDto obter(@PathVariable(value="idCamada") int idCamada) throws Exception{		 	 
		return service.obter(idCamada);
	}
		
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Atualiza uma camada")
	@PutMapping(value="/", produces="application/json")
	public @ResponseBody CamadaReadDto  atualizar(@RequestBody @Valid CamadaUpdateDto camadaUpdateDto) throws Exception{			
		return service.atualizar(camadaUpdateDto);
	}
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Excluir uma camada")
	@DeleteMapping(value="/", produces="application/json")
	public @ResponseBody CamadaReadDto  excluir(@RequestParam(value="idCamada") int idCamada) throws Exception{			
		return service.excluir(idCamada);
	}
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Lista camadas por situação (0 - INATIVA, 1 - ATIVA, 2 - BLOQUEADA, 3 - EXCLUIDA)")
	@GetMapping(value="/PorSituacao/{situacao}", produces="application/json")
	public @ResponseBody Iterable<CamadaReadDto> listarPorSituacao(@PathVariable(value="situacao") int situacao) throws Exception {			 
		return service.listarPorSituacao(situacao);		
	}		
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Lista com todas as camadas")
	@GetMapping(value = "/", produces = "application/json; charset=UTF-8")
	public @ResponseBody Iterable<CamadaReadDto> listar() throws Exception {			 
		return service.listar();		
	}	
	
	
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value="Obtem situações de uma camada")
	@GetMapping(value="/situacoesCamada", produces="application/json")
	public @ResponseBody Iterable<SituacaoCamada> situacoesCamada() throws Exception{		 	 
		return service.situacoesCamada();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
