package org.sadpa.resources;
import javax.validation.Valid;

import org.sadpa.dto.CamadaDto;
import org.sadpa.models.Camada;
import org.sadpa.services.CamadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/camada")
public class CamadaResource {

	@Autowired
	private CamadaService service;
	
	//Padrão de nomeclatura dos método: Listar, Cadastrar, Obter, Atualizar, Excluir
	
	@ApiOperation(value="Retorna uma lista com todas as camadas")
	@GetMapping(value = "/", produces = "application/json; charset=UTF-8")
	public @ResponseBody Iterable<Camada> listarCamadas() {			 
		return service.listarCamadas();		
	}	
	
	@ApiOperation(value="Cadastro uma nova camada e seus campos")
	@PostMapping()
	public CamadaDto cadastrarCamada(@RequestBody @Valid CamadaDto camada) throws Exception{								
		return service.cadastrarCamada(camada);
	}
	
	@ApiOperation(value="Retorna uma camada específica")
	@GetMapping(value="/{idCamada}", produces="application/json")
	public @ResponseBody CamadaDto obterCamada(@PathVariable(value="idCamada") int idCamada){		 	 
		return service.obterCamada(idCamada);
	}
		
	
}
