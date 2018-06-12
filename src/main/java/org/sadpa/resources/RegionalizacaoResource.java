package org.sadpa.resources;
import javax.validation.Valid;
import org.sadpa.dto.RegionalizacaoCreateDto;
import org.sadpa.dto.RegionalizacaoUpdateDto;
import org.sadpa.models.Regionalizacao;
import org.sadpa.services.RegionalizacaoService;
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
@RequestMapping("/regionalizacao")
@Api(description = "Regionalização")
public class RegionalizacaoResource {

	@Autowired
	private RegionalizacaoService service;
		
	@CrossOrigin(origins = "*")
	@PostMapping()
	public Regionalizacao cadastrar(@RequestBody @Valid RegionalizacaoCreateDto regionalizacaoCreateDto) throws Exception{								
		return service.cadastrar(regionalizacaoCreateDto);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("{idRegionalizacao}")
	public  Regionalizacao obter(@PathVariable(value="idRegionalizacao") int idRegionalizacao) throws Exception{		 	 
		return service.obter(idRegionalizacao);
	}
		
	@CrossOrigin(origins = "*")
	@PutMapping()
	public Regionalizacao  atualizar(@RequestBody @Valid RegionalizacaoUpdateDto regionalizacaoUpdateDto) throws Exception{			
		return service.atualizar(regionalizacaoUpdateDto);
	}
	
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("{idRegionalizacao}")
	public  Regionalizacao  excluir(@PathVariable(value="idRegionalizacao") int idRegionalizacao) throws Exception{			
		return service.excluir(idRegionalizacao);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/PorSituacao/{situacao}")
	public Iterable<Regionalizacao> listarPorSituacao(@PathVariable(value="situacao") int situacao) throws Exception {			 
		return service.listarPorSituacao(situacao);		
	}	
	
	@CrossOrigin(origins = "*")
	@GetMapping()
	public Iterable<Regionalizacao> listar() throws Exception {			 
		return service.listar();
	}	

}
