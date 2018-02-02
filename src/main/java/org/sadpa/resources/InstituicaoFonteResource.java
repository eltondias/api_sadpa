package org.sadpa.resources;
import javax.validation.Valid;

import org.sadpa.dto.CamadaReadDto;
import org.sadpa.dto.InstituicaoFonteCreateDto;
import org.sadpa.models.InstituicaoFonte;
import org.sadpa.services.InstituicaoFonteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/instituicaofonte")
@Api(description = "Instituições fontes")
public class InstituicaoFonteResource {

	@Autowired
	private InstituicaoFonteService service;
		
	@ApiOperation(value="Cadastra uma nova instituição fonte")
	@PostMapping() 
	public InstituicaoFonte cadastrar(@RequestBody @Valid InstituicaoFonteCreateDto instituicaoFonte) throws Exception{								
		return service.cadastrar(instituicaoFonte);
	}
	
	@ApiOperation(value="Obtem uma camada pelo id da Instituicao")
	@GetMapping(value="/{idInstituicao}", produces="application/json")
	public @ResponseBody InstituicaoFonte obterInstituicao(@PathVariable(value="idInstituicao") int idInstituicao) throws Exception{		 	 
		return service.obterInstituicao(idInstituicao);
	}
	
	@ApiOperation(value="Lista camadas por situação (0 - INATIVA, 1 - ATIVA, 2 - BLOQUEADA, 3 - EXCLUIDA)")
	@GetMapping(value="/PorSituacao/{situacao}", produces="application/json")
	public @ResponseBody Iterable<InstituicaoFonte> listarInstituicoesPorSituacao(@PathVariable(value="situacao") int situacao) throws Exception {			 
		return service.listarInstituicoesPorSituacao(situacao);		
	}	
	
	@ApiOperation(value="Lista com todas as instituições fonte")
	@GetMapping(value = "/", produces = "application/json; charset=UTF-8")
	public @ResponseBody Iterable<InstituicaoFonte> listarTodasInstituicoes() throws Exception {			 
		return service.listarTodasInstituicoes();		
	}	
	
}
