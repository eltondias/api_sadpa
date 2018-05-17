package org.sadpa.services;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.sadpa.constants.Situacao;
import org.sadpa.dto.CamadaCreateDto;
import org.sadpa.dto.CamadaReadDto;
import org.sadpa.dto.CamadaUpdateDto;
import org.sadpa.dto.CampoCreateDto;
import org.sadpa.dto.CampoReadDto;
import org.sadpa.dto.CampoUpdateDto;
import org.sadpa.dto.UsuarioCamadaCreateDto;
import org.sadpa.models.Camada;
import org.sadpa.models.Campo;
import org.sadpa.models.SituacaoCamada;
import org.sadpa.models.TipoCampo;
import org.sadpa.models.Usuario;
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

 
		
	private static CamadaReadDto responseCamadaReadDto = null;

 

	public CamadaReadDto cadastrar(CamadaCreateDto camadaCreateDto) throws Exception {

		try {
			
			for (CampoCreateDto  item: camadaCreateDto.getCampos()) {
				System.out.println("Nome:" + item.getNome() + " - titulo:" + item.isTitulo());
			}
			
			
			
			verificaNomeCamada(camadaCreateDto.getNome());		 													
			verificaTipoCampos(camadaCreateDto.getCampos());
									
			Camada camada = modelMapper.map(camadaCreateDto, Camada.class);			
			camada.setDataHoraInsercao(Calendar.getInstance());
			camada.setSituacao(Situacao.ATIVO);
			
			
			
			List<Usuario> usuarios = new ArrayList<Usuario>();
			
			for (UsuarioCamadaCreateDto usuario: camadaCreateDto.getUsuarios()) {					 							
				usuarios.add(modelMapper.map(usuario, Usuario.class));
			}
			
			camada.setUsuario(usuarios);
			camadaRepository.save(camada);

			//CADASTRO DOS CAMPOS DA CAMADA
			List<CampoReadDto> campos = new ArrayList<CampoReadDto>();
			for (CampoCreateDto campoCreateDto : camadaCreateDto.getCampos()) 
			{					
				Campo campo =  new Campo();
				campo.setNome(campoCreateDto.getNome());
				campo.setObrigatorio(campoCreateDto.isObrigatorio());
				campo.setTitulo(campoCreateDto.isTitulo());				
				campo.setTipoCampo(tipoCampoRepository.findByIdTipoCampo(campoCreateDto.getTipoCampo().getIdTipoCampo()));
				campo.setCamada(camada);											 			 				 				
				campo.setDataHoraInsercao(Calendar.getInstance());	
				campo.setSituacao(Situacao.ATIVO);
				campo = campoRepository.save(campo);							
				campos.add(modelMapper.map(campo, CampoReadDto.class));				
			}

			responseCamadaReadDto = modelMapper.map(camada, CamadaReadDto.class);
			responseCamadaReadDto.add(linkTo(methodOn(CamadaResource.class).obter(responseCamadaReadDto.getIdCamada())).withSelfRel());
			responseCamadaReadDto.setCampos(campos);
			
			return responseCamadaReadDto;

		} catch (Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}
	
	public CamadaReadDto obter(int idCamada) throws Exception {

		List<CampoReadDto> camposReadDto = new ArrayList<CampoReadDto>();		
		Camada camada = camadaRepository.findByIdCamada(idCamada);		
		
		if(camada == null )
			 throw new Exception("Camada não existe!");
		
		if (camada.getSituacao() == Situacao.EXCLUIDO)
			throw new Exception("Camada excluída");
		
		List<Campo> campos = campoRepository.findByCamada(camada);		
		CamadaReadDto camadaResponse = modelMapper.map(camada, CamadaReadDto.class);

		for (Campo campo : campos) 
			camposReadDto.add(modelMapper.map(campo, CampoReadDto.class));
		
		camadaResponse.setCampos(camposReadDto);
		
		camadaResponse.setUsuarios(camada.getUsuario());
		
		
		return camadaResponse;
	}
	
	public CamadaReadDto atualizar(CamadaUpdateDto camadaUpdateDto) throws Exception {
		try {	
			
			Calendar dataAtual = Calendar.getInstance();
			
			verificaTipoCampos(camadaUpdateDto.getCampos());
			
			List<CampoReadDto> campos = new ArrayList<CampoReadDto>();
			Camada oCamada =   camadaRepository.findByIdCamada(camadaUpdateDto.getIdCamada());
			
			
			if (!camadaUpdateDto.getNome().contains(oCamada.getNome()) )
				verificaNomeCamada(camadaUpdateDto.getNome());
			
			if(oCamada.getSituacao() != Situacao.EXCLUIDO) {
			
				oCamada.setDescricao(camadaUpdateDto.getDescricao());
				oCamada.setNome(camadaUpdateDto.getNome());
				oCamada.setSituacao(camadaUpdateDto.getSituacao());
				oCamada.setDataHoraAtualizacao(Calendar.getInstance());
				camadaRepository.save(oCamada);	
							
				for (CampoUpdateDto campoUpdateDto : camadaUpdateDto.getCampos()) {				
					
						Campo  campo = campoRepository.findByIdCampo(campoUpdateDto.getIdCampo());	
						
						if(campo == null) {
							campo = new Campo();
							campo.setDataHoraInsercao(dataAtual);
						}else 
							campo.setDataHoraAtualizacao(dataAtual);		
																
						if (campoUpdateDto.getSituacao() == Situacao.EXCLUIDO)
							campo.setDataHoraExclusao(dataAtual);
						
						campo.setCamada(oCamada);
						campo.setNome(campoUpdateDto.getNome());
						campo.setObrigatorio(campoUpdateDto.isObrigatorio());
						campo.setTipoCampo(campoUpdateDto.getTipoCampo());
						campo.setTitulo(campoUpdateDto.isTitulo());
						campo.setSituacao(campoUpdateDto.getSituacao());
										
					 	campoRepository.save(campo);					 
					 	campos.add(modelMapper.map(campo, CampoReadDto.class));
				}
				
				responseCamadaReadDto = modelMapper.map(oCamada, CamadaReadDto.class);			
				responseCamadaReadDto.setCampos(campos);
				return responseCamadaReadDto;
			
			}else 
				throw new Exception("Essa camada não pode ser atualizada pois a mesma está com situação = EXCLUIDA (3), favor entrar em contato com o administrador do sistema");
									
		} catch (Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}

	public CamadaReadDto excluir(int idCamada) throws Exception {
		
		Calendar dataAtual = Calendar.getInstance();
		Camada camada = camadaRepository.findByIdCamada(idCamada);		
	
		if (camada != null)
		{
			if (camada.getSituacao() == Situacao.EXCLUIDO)
				throw new Exception("Camada já foi excluída");
			
			camada.setSituacao(Situacao.EXCLUIDO); 
			camada.setDataHoraExclusao(dataAtual);
			camadaRepository.save(camada);	
			
			List<CampoReadDto> camposReadDto =  new ArrayList<CampoReadDto>();
			List<Campo> campos =  campoRepository.findByCamada(camada);
			
			for (Campo campo : campos) {				
				campo.setSituacao(Situacao.EXCLUIDO);				
				campo.setDataHoraExclusao(dataAtual);
				campoRepository.save(campo);				
				camposReadDto.add(modelMapper.map(campo, CampoReadDto.class));
			}
										
			responseCamadaReadDto = 	modelMapper.map(camada, CamadaReadDto.class);					
			responseCamadaReadDto.setCampos(camposReadDto);
			return 	responseCamadaReadDto;	 
						
		}else 
			throw new Exception("Camada não existe");
		
	}
	
	public Iterable<CamadaReadDto> listarPorSituacao(int situacao ) throws Exception {
				
		Iterable<Camada> listaCamadas = camadaRepository.findBySituacaoAndOrder(situacao);
				
		ArrayList<CamadaReadDto> camadas = new ArrayList<CamadaReadDto>();
		
		for (Camada camada : listaCamadas) {	
			
			 List<Campo> camposCamada = campoRepository.findByCamadaAndSituacao(camada, 2);
			 List<CampoReadDto> campos = new ArrayList<CampoReadDto>();
			 
			 for (Campo campo : camposCamada) 				 
				 campos.add(modelMapper.map(campo, CampoReadDto.class));
			
			 CamadaReadDto camadaRead  = modelMapper.map(camada, CamadaReadDto.class);			 
			 camadaRead.setCampos(campos);			
			 camadaRead.add(linkTo(methodOn(CamadaResource.class).obter(camada.getIdCamada())).withSelfRel());
			 camadas.add(camadaRead);			
		}
		
		return camadas;
	}

	public Iterable<CamadaReadDto> listar() throws Exception {
		
		Iterable<Camada> listaCamadas = camadaRepository.findAll();
				
		ArrayList<CamadaReadDto> camadas = new ArrayList<CamadaReadDto>();
		
		for (Camada camada : listaCamadas) {				
			 List<Campo> camposCamada = campoRepository.findByCamada(camada);
			 List<CampoReadDto> campos = new ArrayList<CampoReadDto>();			 
			 for (Campo campo : camposCamada) 				 
				 campos.add(modelMapper.map(campo, CampoReadDto.class));
			
			 CamadaReadDto camadaRead  = modelMapper.map(camada, CamadaReadDto.class);			 
			 camadaRead.setCampos(campos);			
			 camadaRead.add(linkTo(methodOn(CamadaResource.class).obter(camada.getIdCamada())).withSelfRel());
			 camadas.add(camadaRead);			
		}
		
		return camadas;
	}
	
	private void  verificaNomeCamada(String nome) throws Exception {
		
		List<Camada> camadaNome =  camadaRepository.findByNome(nome);			
		if(camadaNome.size() > 0) 				 
			throw new Exception("Já existe uma camada cadastrada com o nome: " + nome); 		
	}
	
	private <T> void verificaTipoCampos(List<T> campos) throws Exception {
		
		for(T campoT : campos) {			
			Campo campo =  modelMapper.map(campoT, Campo.class);					
			TipoCampo tipoCampo = tipoCampoRepository.findByIdTipoCampo(campo.getTipoCampo().getIdTipoCampo());								
			if (tipoCampo == null)
				throw new Exception("Tipo de campo do campo '" + campo.getNome() + "' não existe");	
		}
		 
	}
	
	
	public Iterable<SituacaoCamada> situacoesCamada() throws Exception {
				 				
		ArrayList<SituacaoCamada> situacoes = new ArrayList<SituacaoCamada>(
				Arrays.asList(						
						new SituacaoCamada(0, "Inativa"), 
						new SituacaoCamada(1, "Ativa"), 
						new SituacaoCamada(2, "Bloqueada"), 
						new SituacaoCamada(3, "Excluída")					 						
						)
		);
						
		return situacoes;
	}
	
	
	 
}


