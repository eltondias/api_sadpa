package org.sadpa.services;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import org.modelmapper.ModelMapper;
import org.sadpa.dto.CamadaDto;
import org.sadpa.models.Camada;
import org.sadpa.repositories.CamadaRepository;
import org.sadpa.resources.CamadaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

@Service
public class CamadaService {
	
	 @Autowired
	 private ModelMapper modelMapper;
	
	private static final Calendar dataAtual = Calendar.getInstance();
	
	
	public CamadaService() {		
		dataAtual.setTimeZone(TimeZone.getTimeZone("America/Belem"));	
	}

	@Autowired
	private CamadaRepository repository; 
		
	public Iterable<Camada> getAllCamadas() {		
		Iterable<Camada> listaCamadas = repository.findAll();		
		ArrayList<Camada> camadas = new ArrayList<Camada>();
		for(Camada camada : listaCamadas){		 
			camada.add(linkTo(methodOn(CamadaResource.class).getCamada(camada.getIdCamada())).withSelfRel());
			camadas.add(camada);
		}		
		return camadas;		
	}	
	
	public Camada getCamada(int idCamada){
		Camada camada = repository.findByIdCamada(idCamada);
		camada.add(linkTo(methodOn(CamadaResource.class).getAllCamadas()).withRel("Lista todas as camadas"));
		return camada;		
	}
	
	public CamadaDto postCamada(CamadaDto camadadto){	
		
		//if(!ConsultarPorNome(camada.getNome()).isEmpty())
			//throw new  ExceptionNegocio("Já existe uma camada com esse nome", HttpStatus.PRECONDITION_FAILED);
		
		Camada oCamada = convertToEntity(camadadto);		
		oCamada.setDataHoraInsercao(dataAtual);
		oCamada.setSituacao(true);
		repository.save(oCamada);		
		oCamada.add(linkTo(methodOn(CamadaResource.class).getCamada(oCamada.getIdCamada())).withSelfRel());						
		return convertToDto(oCamada);
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
