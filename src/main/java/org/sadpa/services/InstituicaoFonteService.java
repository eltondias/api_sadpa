package org.sadpa.services;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.modelmapper.ModelMapper;
import org.sadpa.constants.Situacao;
import org.sadpa.dto.CamadaReadDto;
import org.sadpa.dto.CampoReadDto;
import org.sadpa.dto.InstituicaoFonteCreateDto;
import org.sadpa.models.Camada;
import org.sadpa.models.Campo;
import org.sadpa.models.InstituicaoFonte;
import org.sadpa.repositories.InstituicaoFonteRepository;
import org.sadpa.resources.CamadaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoFonteService {
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private InstituicaoFonteRepository instituicaoFonteRepository;
	
	private static final Calendar dataAtual = Calendar.getInstance();
	
	public InstituicaoFonteService() {
		dataAtual.setTimeZone(TimeZone.getTimeZone("America/Belem"));
	}
	
	
	public InstituicaoFonte cadastrar(InstituicaoFonteCreateDto instituicaoFonte) throws Exception {

		try {
			
			InstituicaoFonte instituicao =  new InstituicaoFonte();			
			instituicao.setCnpj(instituicaoFonte.getCnpj());
			instituicao.setNome(instituicaoFonte.getNome());
			instituicao.setDescricao(instituicaoFonte.getDescricao());
			instituicao.setDataHoraInsercao(dataAtual);
			instituicao.setSituacao(Situacao.ATIVO);
			instituicao  = instituicaoFonteRepository.save(instituicao);
			
			 return instituicao;

		} catch (Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}
	
	public InstituicaoFonte obterInstituicao(int idInstituicaoFonte) throws Exception {		 
		return instituicaoFonteRepository.findByIdInstituicaoFonte(idInstituicaoFonte);			 
	}
	
	public Iterable<InstituicaoFonte> listarTodasInstituicoes() throws Exception {		 
		return instituicaoFonteRepository.findAll();	 
	}
	
	public Iterable<InstituicaoFonte> listarInstituicoesPorSituacao(int situacao ) throws Exception {
		
		Iterable<InstituicaoFonte> listarInstituicoes = instituicaoFonteRepository.findBySituacao(situacao);
						 
		return listarInstituicoes;
	}

}
