package org.sadpa.services;

 
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.sadpa.constants.Situacao;
import org.sadpa.dto.CamadaReadDto;
import org.sadpa.dto.CampoReadDto;
import org.sadpa.dto.InstituicaoFonteCreateDto;
import org.sadpa.dto.TipoCampoReadDto;
import org.sadpa.models.Camada;
import org.sadpa.models.Campo;
import org.sadpa.models.InstituicaoFonte;
import org.sadpa.models.TipoCampo;
import org.sadpa.repositories.TipoCampoRepository;
import org.sadpa.resources.CamadaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TiposCampoService {

	@Autowired
	private TipoCampoRepository tipoCampoRepository;
	
	public Iterable<TipoCampo> listar() throws Exception {
		
		Iterable<TipoCampo> listaTiposCampo = tipoCampoRepository.findAll();
						
		return listaTiposCampo;
	}
	
	
	public TipoCampo cadastrar(TipoCampo tipoCampo) throws Exception {

		try {
			
			return tipoCampoRepository.save(tipoCampo);
			
		} catch (Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}
	
	
	 
}
