package org.sadpa.services;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.modelmapper.ModelMapper;
import org.sadpa.dto.CamadaCreateDto;
import org.sadpa.dto.CamadaReadDto;
import org.sadpa.dto.CamadaUpdateDto;
import org.sadpa.dto.CampoDto;
import org.sadpa.models.Camada;
import org.sadpa.models.Campo;
import org.sadpa.models.TipoCampo;
import org.sadpa.repositories.CamadaRepository;
import org.sadpa.repositories.CampoRepository;
import org.sadpa.repositories.TipoCampoRepository;
import org.sadpa.resources.CamadaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamadaService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CamadaRepository camadaRepository;

	@Autowired
	private CampoRepository campoRepository;

	@Autowired
	private TipoCampoRepository tipoCampoRepository;

	private static final Calendar dataAtual = Calendar.getInstance();

	public CamadaService() {
		dataAtual.setTimeZone(TimeZone.getTimeZone("America/Belem"));
	}

	public CamadaCreateDto cadastrarCamada(CamadaCreateDto camadaCadastroDto) throws Exception {

		try {
			
			List<CampoDto> campos = new ArrayList<CampoDto>();
			
			for (CampoDto campoDto : camadaCadastroDto.getCampos()) {			
				TipoCampo tipoCampo = tipoCampoRepository.findByIdTipoCampo(campoDto.getTipoCampo().getIdTipoCampo());								
				if (tipoCampo == null)
					throw new Exception("Tipo de campo do campo '" + campoDto.getNome() + "' não existe");
				
			}
						
			Camada camada = modelMapper.map(camadaCadastroDto, Camada.class);			
			camada.setDataHoraInsercao(dataAtual);
			camada.setSituacao(true);
			camadaRepository.save(camada);

			for (CampoDto campoDto : camadaCadastroDto.getCampos()) {
				Campo campo = modelMapper.map(campoDto, Campo.class);				 				 
				campo.setCamada(camada);
				campo.setDataHoraInsercao(dataAtual);				
				campo = campoRepository.save(campo);				
				campoDto.setIdCampo(campo.getIdCampo());	
				campoDto.setTipoCampo(tipoCampoRepository.findByIdTipoCampo(campo.getTipoCampo().getIdTipoCampo()));
				campos.add(campoDto);				
			}

			CamadaCreateDto objCamadaCadastroDto = modelMapper.map(camada, CamadaCreateDto.class);
			objCamadaCadastroDto.add(linkTo(methodOn(CamadaResource.class).obterCamada(objCamadaCadastroDto.getIdCamada())).withSelfRel());
			objCamadaCadastroDto.setCampos(campos);
			
			return objCamadaCadastroDto;

		} catch (Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}
	
	public CamadaReadDto obterCamada(int idCamada) {

		Camada camada = camadaRepository.findByIdCamada(idCamada);
		List<CampoDto> camposDto = new ArrayList<CampoDto>();
		List<Campo> campos = campoRepository.findByCamada(camada);
		CamadaReadDto camadaResponse = modelMapper.map(camada, CamadaReadDto.class);

		for (Campo campo : campos) 
			camposDto.add(modelMapper.map(campo, CampoDto.class));
		
		camadaResponse.setCampos(camposDto);		
		return camadaResponse;
	}
	
	public CamadaReadDto atualizarCamada(CamadaUpdateDto camadaUpdateDto) throws Exception {
		try {			
			Camada oCamada =   camadaRepository.findByIdCamada(camadaUpdateDto.getIdCamada());
			
			oCamada.setDescricao(camadaUpdateDto.getDescricao());
			oCamada.setNome(camadaUpdateDto.getNome());
			oCamada.setSituacao(camadaUpdateDto.isSituacao());
			oCamada.setDataHoraAtualizacao(dataAtual);
			camadaRepository.save(oCamada);	
						
			for (CampoDto campo : camadaUpdateDto.getCampos()) {				
				
					Campo  oCampo = campoRepository.findByIdCampo(campo.getIdCampo());		
								
					if(oCampo == null) 
						oCampo = new Campo();
										
					oCampo.setCamada(oCamada);
					oCampo.setNome(campo.getNome());
					oCampo.setObrigatorio(campo.isObrigatorio());
					oCampo.setTipoCampo(campo.getTipoCampo());
					oCampo.setTitulo(campo.isTitulo());		
					oCampo.setDataHoraAtualizacao(dataAtual);
					
				 	campoRepository.save(oCampo);						 			 
			}
			
			CamadaReadDto camadaResponse = modelMapper.map(oCamada, CamadaReadDto.class);			
			camadaResponse.setCampos(camadaUpdateDto.getCampos());
						
			return camadaResponse;

		} catch (Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}

	public CamadaReadDto excluirCamada(int idCamada) {
		Camada camada = camadaRepository.findByIdCamada(idCamada);
		camada.setSituacao(false);		
		camada.setDataHoraExclusao(dataAtual);
		camadaRepository.save(camada);		
		return modelMapper.map(camada, CamadaReadDto.class);			 
	}
	
	public Iterable<CamadaReadDto> listarCamadas() {
				
		Iterable<Camada> listaCamadas = camadaRepository.findBySituacao(true);
				
		ArrayList<CamadaReadDto> camadas = new ArrayList<CamadaReadDto>();
		
		for (Camada camada : listaCamadas) {			
			 List<Campo> campos = campoRepository.findByCamada(camada);
			 List<CampoDto> camposDto = new ArrayList<CampoDto>();
			 for (Campo campo :campos) 				 
				 camposDto.add(modelMapper.map(campo, CampoDto.class));
			
			 CamadaReadDto camadaRead  = modelMapper.map(camada, CamadaReadDto.class);
			 
			 camadaRead.setCampos(camposDto);
			
			 camadaRead.add(linkTo(methodOn(CamadaResource.class).obterCamada(camada.getIdCamada())).withSelfRel());
			camadas.add(camadaRead);			
		}
		
		return camadas;
	}

	
	
	
	
	
	
	
	
	
	
	

	 
}
