package org.sadpa.resources;
import javax.validation.Valid;

import org.sadpa.dto.InstituicaoFonteCreateDto;
import org.sadpa.dto.InstituicaoFonteUpdateDto;
import org.sadpa.models.InstituicaoFonte;
import org.sadpa.services.InstituicaoFonteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/instituicaofonte")
@Api(description = "Instituições fontes")
public class InstituicaoFonteResource {

	@Autowired
	private InstituicaoFonteService service;
		
	@ApiOperation(value="Cadastra instituição fonte")
	@PostMapping() 
	public InstituicaoFonte cadastrar(@RequestBody @Valid InstituicaoFonteCreateDto instituicaoFonte) throws Exception{								
		return service.cadastrar(instituicaoFonte);
	}
	
	@ApiOperation(value="Obtem Instituicao")
	@GetMapping("{idInstituicao}")
	public @ResponseBody InstituicaoFonte obter(@PathVariable(value="idInstituicao") int idInstituicao) throws Exception{		 	 
		return service.obter(idInstituicao);
	}
		
	@ApiOperation(value="Atualiza instituição fonte")
	@PutMapping()
	public @ResponseBody InstituicaoFonte  atualizar(@RequestBody @Valid InstituicaoFonteUpdateDto instituicaoFonteUpdateDto) throws Exception{			
		return service.atualizar(instituicaoFonteUpdateDto);
	}
	
	
	@ApiOperation(value="Excluir Instituicao fonte")
	@DeleteMapping(value="/{idInstituicao}")
	public @ResponseBody InstituicaoFonte excluir(@PathVariable(value="idInstituicao") int idInstituicao) throws Exception{		 	 
		return service.excluir(idInstituicao);
	}
	
	
	@ApiOperation(value="Lista instituições fonte por situação (0 - INATIVA, 1 - ATIVA, 2 - BLOQUEADA, 3 - EXCLUIDA)")
	@GetMapping(value="/PorSituacao/{situacao}")
	public @ResponseBody Iterable<InstituicaoFonte> listarPorSituacao(@PathVariable(value="situacao") int situacao) throws Exception {			 
		return service.listarPorSituacao(situacao);		
	}	
		 
	@ApiOperation(value="Lista com todas as instituições fonte")
	@GetMapping()
	public @ResponseBody Iterable<InstituicaoFonte> listar() throws Exception {			 
		return service.listar();		
	}	 
	
	
	
	
}
