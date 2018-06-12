package org.sadpa.resources;

import java.util.List;
import org.sadpa.models.Municipio;
import org.sadpa.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
 
@RestController
@RequestMapping("/municipio")
@Api(description = "Municipios")
public class MunicipioResource {

	@Autowired
	private MunicipioService service;
		
	@CrossOrigin(origins = "*")
	@GetMapping("{idMunicipio}")
	public  Municipio obter(@PathVariable(value="idMunicipio") int idMunicipio) throws Exception{		 	 
		return service.obter(idMunicipio);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping()
	public Iterable<Municipio> listar() throws Exception {			 
		return service.listar();
	}	
	
	@CrossOrigin(origins = "*")
	@GetMapping("porEstado/{idEstado}")
	public Iterable<Municipio> porEstado(@PathVariable(value="idEstado") int idEstado) throws Exception {			 
		return service.porEstado(idEstado);
	}	
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/filtrar/{filtro}", produces="application/json")
	public @ResponseBody List<Municipio> filtrar(@PathVariable(value="filtro") String filtro) throws Exception {			 
		return service.filtrar(filtro);		
	}	
	
}
