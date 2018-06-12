package org.sadpa.resources;

import javax.validation.Valid;

import org.sadpa.dto.RegiaoCreateDto;
import org.sadpa.dto.RegiaoUpdateDto;
import org.sadpa.models.Regiao;
import org.sadpa.services.RegiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
 
@RestController
@RequestMapping("/regiao")
@Api(description = "Regiões de integração")
public class RegiaoResource {

	@Autowired
	private RegiaoService service;
		
	@CrossOrigin(origins = "*")
	@PostMapping()
	public Regiao cadastrar(@RequestBody @Valid RegiaoCreateDto regiaoCreateDto)throws Exception{
		return service.cadastrar(regiaoCreateDto);
	}
		
	@CrossOrigin(origins = "*")
	@GetMapping("{idRegiao}")
	public  Regiao obter(@PathVariable(value="idRegiao") int idRegiao) throws Exception{		 	 
		return service.obter(idRegiao);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping()
	public Regiao  atualizar(@RequestBody @Valid RegiaoUpdateDto regiaoUpdateDto) throws Exception{			
		return service.atualizar(regiaoUpdateDto);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("{idRegiao}")
	public  Regiao  excluir(@PathVariable(value="idRegiao") int idRegiao) throws Exception{			
		return service.excluir(idRegiao);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/PorSituacao/{situacao}")
	public Iterable<Regiao> listarPorSituacao(@PathVariable(value="situacao") int situacao) throws Exception {			 
		return service.listarPorSituacao(situacao);		
	}	

	@CrossOrigin(origins = "*")
	@GetMapping()
	public Iterable<Regiao> listar() throws Exception {			 
		return service.listar();
	}	 
	
}
