package org.sadpa.services;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.modelmapper.ModelMapper;
import org.sadpa.dto.CamadaCadastroDto;
import org.sadpa.dto.CamadaDto;
import org.sadpa.dto.CampoDto;
import org.sadpa.models.Camada;
import org.sadpa.models.Campo;
import org.sadpa.repositories.CamadaRepository;
import org.sadpa.repositories.CampoRepository;
import org.sadpa.resources.CamadaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

@Service
public class CamadaService {
	
	 @Autowired
	 private ModelMapper modelMapper;
	 
	 @Autowired
	 private CamadaRepository camadaRepository; 
	 
	 @Autowired
	 private CampoRepository campoRepository;
	
	private static final Calendar dataAtual = Calendar.getInstance();
	
	
	public CamadaService() {		
		dataAtual.setTimeZone(TimeZone.getTimeZone("America/Belem"));	
	}

	
		
	public Iterable<Camada> getAllCamadas() {		
		Iterable<Camada> listaCamadas = camadaRepository.findAll();		
		ArrayList<Camada> camadas = new ArrayList<Camada>();
		for(Camada camada : listaCamadas){		 
			camada.add(linkTo(methodOn(CamadaResource.class).getCamada(camada.getIdCamada())).withSelfRel());
			camadas.add(camada);
		}		
		return camadas;		
	}	
	
	public Camada getCamada(int idCamada){
		Camada camada = camadaRepository.findByIdCamada(idCamada);
		camada.add(linkTo(methodOn(CamadaResource.class).getAllCamadas()).withRel("Lista todas as camadas"));
		return camada;		
	}
	
	
	 
	public CamadaCadastroDto cadastraCamadaCampos(CamadaCadastroDto camadaCadastroDto){	
		
		List<CampoDto> campos = new  ArrayList<CampoDto>();
		
		Camada camada =  modelMapper.map(camadaCadastroDto, Camada.class);	 		
		camada.setDataHoraInsercao(dataAtual);
		camada.setSituacao(true);
		camadaRepository.save(camada);			
		
		for(CampoDto campoDto : camadaCadastroDto.getCampos() ){				
			Campo campo =  modelMapper.map(campoDto, Campo.class);									
			campo.setCamada(camada);
			campoRepository.save(campo);
			campos.add(modelMapper.map(campo, CampoDto.class));						
		}		
				
		CamadaCadastroDto objCamadaCadastroDto = modelMapper.map(camada, CamadaCadastroDto.class);
		
		//objCamadaCadastroDto.add(linkTo(methodOn(CamadaResource.class).getCamada(objCamadaCadastroDto.getIdCamada())).withSelfRel());	
		
		objCamadaCadastroDto.setCampos(campos);	 
		
		return objCamadaCadastroDto;
	}

	
	public Camada convertToEntity(CamadaDto CamadaDto) throws ParseException {
	    Camada Camada = modelMapper.map(CamadaDto, Camada.class);	   	 	
	    return Camada;
	}
		
	public CamadaDto convertToDto(Camada camada) {
		CamadaDto camadaDto = modelMapper.map(camada, CamadaDto.class);	 
	    return camadaDto;
	}
	
	
}
