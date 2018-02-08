package org.sadpa.services;

 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.sadpa.constants.Situacao;
import org.sadpa.dto.CamadaUsuarioDto;
import org.sadpa.dto.UsuarioCreateDto;
import org.sadpa.dto.UsuarioReadDto;
import org.sadpa.dto.UsuarioUpdateDto;
import org.sadpa.models.Camada;
import org.sadpa.models.Usuario;
import org.sadpa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(UsuarioCreateDto usuarioCreateDto) {			 
		  Usuario  usuario = modelMapper.map(usuarioCreateDto, Usuario.class);
		  usuario.setDataHoraInsercao(Calendar.getInstance());
		  usuario.setSituacao(Situacao.ATIVO);
		  usuarioRepository.save(usuario);
		  return usuario;
	}
	
	public UsuarioReadDto obter(int idUsuario) {	
		
		Usuario usuario = usuarioRepository.findByIdUsuario(idUsuario);		
		UsuarioReadDto usuarioResponse =  modelMapper.map(usuario, UsuarioReadDto.class);	
		List<CamadaUsuarioDto> camadas =  new ArrayList<CamadaUsuarioDto>();
		
		for ( Camada camada  : usuario.getCamadas())  	 			
			camadas.add(modelMapper.map(camada, CamadaUsuarioDto.class));
		
		usuarioResponse.setCamadas(camadas);		
		return usuarioResponse;		
	}
	
	public Usuario atualizar(UsuarioUpdateDto usuarioUpdateDto) {						
		Usuario usuario =  modelMapper.map(usuarioUpdateDto, Usuario.class);		
		usuario.setDataHoraAtualizacao(Calendar.getInstance());	
		Usuario usuarioAtual = usuarioRepository.findByIdUsuario(usuarioUpdateDto.getIdUsuario());	
		usuario.setDataHoraInsercao(usuarioAtual.getDataHoraInsercao());
		return usuarioRepository.save(usuario);		
	}

	public Usuario excluir(int idUsuario) {
		Usuario usuario = usuarioRepository.findByIdUsuario(idUsuario);	
		usuario.setDataHoraExclusao(Calendar.getInstance());
		usuario.setSituacao(Situacao.EXCLUIDO);
		return usuarioRepository.save(usuario);
	}
		
	public Iterable<UsuarioReadDto> listar() throws Exception {			
		 Iterable<Usuario> usuarios = usuarioRepository.findAll();	 		 		
		 return ConvertListaUsuarioToUsuarioReadDto(usuarios);
	}
	
	public Iterable<UsuarioReadDto> listarPorSituacao(int situacao) throws Exception {	
		 Iterable<Usuario> usuarios = usuarioRepository.findBySituacao(situacao);
		 return ConvertListaUsuarioToUsuarioReadDto(usuarios); 
	}
	
	private Iterable<UsuarioReadDto> ConvertListaUsuarioToUsuarioReadDto(Iterable<Usuario> usuarios){				 	 
		 List<UsuarioReadDto> usuariosResposnse =  new ArrayList<UsuarioReadDto>();		 
		 for(  Usuario usuario :usuarios) {			 
			 UsuarioReadDto usuarioResp =  modelMapper.map(usuario, UsuarioReadDto.class);			 
			 List<CamadaUsuarioDto> camadas =  new ArrayList<CamadaUsuarioDto>();			 
		     for ( Camada camada  : usuario.getCamadas())  	 {			
					camadas.add(modelMapper.map(camada, CamadaUsuarioDto.class));
		     }				
			 usuarioResp.setCamadas(camadas);					
			 usuariosResposnse.add(usuarioResp);			 			
		 }		 		
		return usuariosResposnse;
	}
}
