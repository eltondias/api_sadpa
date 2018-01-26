package org.sadpa.services;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.modelmapper.ModelMapper;
import org.sadpa.dto.CamadaDto;
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

	public Iterable<Camada> listarCamadas() {
		Iterable<Camada> listaCamadas = camadaRepository.findAll();
		ArrayList<Camada> camadas = new ArrayList<Camada>();
		for (Camada camada : listaCamadas) {
			camada.add(linkTo(methodOn(CamadaResource.class).obterCamada(camada.getIdCamada())).withSelfRel());
			camadas.add(camada);
		}
		return camadas;
	}

	public CamadaDto obterCamada(int idCamada) {

		Camada camada = camadaRepository.findByIdCamada(idCamada);
		List<CampoDto> camposDto = new ArrayList<CampoDto>();
		List<Campo> campos = campoRepository.findByCamada(camada);
		CamadaDto camadaResponse = modelMapper.map(camada, CamadaDto.class);

		for (Campo campo : campos) {
			camposDto.add(modelMapper.map(campo, CampoDto.class));
		}
		camadaResponse.setCampos(camposDto);

		camadaResponse.add(linkTo(methodOn(CamadaResource.class).listarCamadas()).withRel("Lista todas as camadas"));
		return camadaResponse;
	}

	public CamadaDto cadastrarCamada(CamadaDto camadaCadastroDto) throws Exception {

		try {
			
			List<CampoDto> campos = new ArrayList<CampoDto>();
			
			for (CampoDto campoDto : camadaCadastroDto.getCampos()) {

				Campo campo = modelMapper.map(campoDto, Campo.class);
				TipoCampo tipoCampo = tipoCampoRepository.findByIdTipoCampo(campo.getTipoCampo().getIdTipoCampo());
				campo.setTipoCampo(tipoCampo);
				
				if (tipoCampo == null)
					throw new Exception("Tipo de campo do campo '" + campo.getNome() + "' não existe");
			}
						
			Camada camada = modelMapper.map(camadaCadastroDto, Camada.class);			
			camada.setDataHoraInsercao(dataAtual);
			camada.setSituacao(true);
			camadaRepository.save(camada);

			for (CampoDto campoDto : camadaCadastroDto.getCampos()) {
				Campo campo = modelMapper.map(campoDto, Campo.class);
				campo.setCamada(camada);
				campoRepository.save(campo);
				campos.add(modelMapper.map(campo, CampoDto.class));
			}

			CamadaDto objCamadaCadastroDto = modelMapper.map(camada, CamadaDto.class);

			objCamadaCadastroDto.add(
					linkTo(methodOn(CamadaResource.class).obterCamada(objCamadaCadastroDto.getIdCamada())).withSelfRel());

			objCamadaCadastroDto.setCampos(campos);

			return objCamadaCadastroDto;

		} catch (Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}

 

	 
}
