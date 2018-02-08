package org.sadpa.resources;
import javax.validation.Valid;
import org.sadpa.dto.UsuarioCreateDto;
import org.sadpa.dto.UsuarioReadDto;
import org.sadpa.dto.UsuarioUpdateDto;
import org.sadpa.models.Usuario;
import org.sadpa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/usuario")
@Api(description = "Usuários")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
		

	@PostMapping()
	public Usuario cadastrar(@RequestBody @Valid UsuarioCreateDto UsuarioCreateDto) throws Exception{								
		return service.cadastrar(UsuarioCreateDto);
	}
	
	@GetMapping("{idUsuario}")
	public  UsuarioReadDto obter(@PathVariable(value="idUsuario") int idUsuario) throws Exception{		 	 
		return service.obter(idUsuario);
	}
		
	@PutMapping()
	public Usuario  atualizar(@RequestBody @Valid UsuarioUpdateDto UsuarioUpdateDto) throws Exception{			
		return service.atualizar(UsuarioUpdateDto);
	}
	
	@DeleteMapping()
	public  Usuario  excluir(@RequestParam(value="idUsuario") int idUsuario) throws Exception{			
		return service.excluir(idUsuario);
	}
	
	@GetMapping("/PorSituacao/{situacao}")
	public Iterable<Usuario> listarPorSituacao(@PathVariable(value="situacao") int situacao) throws Exception {			 
		return service.listarPorSituacao(situacao);		
	}	
	
	@GetMapping()
	public Iterable<UsuarioReadDto> listar() throws Exception {			 
		return service.listar();
	}	

}
