package org.sadpa.resources;

import javax.validation.Valid;

import org.sadpa.dto.RegiaoCreateDto;
import org.sadpa.dto.RegiaoUpdateDto;
import org.sadpa.models.Regiao;
import org.sadpa.services.RegiaoService;
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
@RequestMapping("/regiao")
@Api(description = "Regiões de integração")
public class RegiaoResource {

	@Autowired
	private RegiaoService service;
		
	
	@PostMapping()
	public Regiao cadastrarRegiao(@RequestBody @Valid RegiaoCreateDto regiaoCreateDto)throws Exception{
		return service.cadastrarRegiao(regiaoCreateDto);
	}
		 
	@GetMapping("{idRegiao}")
	public  Regiao obterRegiao(@PathVariable(value="idRegiao") int idRegiao) throws Exception{		 	 
		return service.obterRegiao(idRegiao);
	}
	
	@PutMapping()
	public Regiao  atualizarRegiao(@RequestBody @Valid RegiaoUpdateDto regiaoUpdateDto) throws Exception{			
		return service.atualizarRegiao(regiaoUpdateDto);
	}
	
	@DeleteMapping()
	public  Regiao  excluirRegiao(@RequestParam(value="idCamada") int idRegiao) throws Exception{			
		return service.excluirRegiao(idRegiao);
	}
	
	@GetMapping("/PorSituacao/{situacao}")
	public Iterable<Regiao> listarRegiaoPorSituacao(@PathVariable(value="situacao") int situacao) throws Exception {			 
		return service.listarRegioesPorSituacao(situacao);		
	}	

	@GetMapping()
	public Iterable<Regiao> listarRegioes() throws Exception {			 
		return service.listarRegioes();
	}	 
	
}
