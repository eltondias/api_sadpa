package org.sadpa.resources;
import javax.validation.Valid;

 
import org.sadpa.models.TipoCampo;
import org.sadpa.services.TiposCampoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tiposcampo")
@Api(description = "TiposCampo")
public class TiposCampoResouce {

	@Autowired
	private TiposCampoService service;
		
	@CrossOrigin(origins = "*")
	@GetMapping()
	public Iterable<TipoCampo> listar() throws Exception {			 
		return service.listar();
	}	

	@ApiOperation(value="Cadastra  um novo tipo de campo")
	@PostMapping()
	public TipoCampo cadastrar(@RequestBody @Valid TipoCampo tipocampo) throws Exception{								
		return service.cadastrar(tipocampo);
	}
	
}
