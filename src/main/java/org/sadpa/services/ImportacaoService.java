package org.sadpa.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.sadpa.dto.ImportacaoCreateDto;
import org.sadpa.models.Camada;
import org.sadpa.models.Campo;
import org.sadpa.models.ValorCampo;
import org.sadpa.models.Geodado;
import org.sadpa.models.InstituicaoFonte;
import org.sadpa.models.LoteImportacao;
import org.sadpa.models.Municipio;
import org.sadpa.models.Usuario;
import org.sadpa.repositories.CamadaRepository;
import org.sadpa.repositories.ValorCampoRepository;
import org.sadpa.repositories.CampoRepository;
import org.sadpa.repositories.GeodadoRepository;
import org.sadpa.repositories.InstituicaoFonteRepository;
import org.sadpa.repositories.LoteImportacaoRepository;
import org.sadpa.repositories.MunicipioRepository;
import org.sadpa.repositories.UsuarioRepository;
import org.sadpa.utils.DataHora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportacaoService {

	@Autowired
	private GeodadoRepository geodadoRepository;

	@Autowired
	private InstituicaoFonteRepository instituicaoFonteRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private MunicipioRepository municipioRepository;

	@Autowired
	private CamadaRepository camadaRepository;

	@Autowired
	private CampoRepository campoRepository;

	@Autowired
	private LoteImportacaoRepository loteImportacaoRepository;

	@Autowired
	private ValorCampoRepository ValorCampoRepository;

	public void importar(ImportacaoCreateDto importacaoCreateDto) throws Exception {

		Camada camada = camadaRepository.findByIdCamada(importacaoCreateDto.getIdCamada());
		List<Campo> campos = campoRepository.findByCamada(camada);
		Usuario usuario = usuarioRepository.findByIdUsuario(importacaoCreateDto.getIdUsuario());
		Municipio municipio = municipioRepository.findByIdMunicipio(importacaoCreateDto.getIdMunicipio());
		InstituicaoFonte instituicaoFonte = instituicaoFonteRepository.findByIdInstituicaoFonte(importacaoCreateDto.getIdInstituicaoFonte());

		LoteImportacao loteImportacao = new LoteImportacao();
		loteImportacao.setDataHora(DataHora.getDataHora());
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		
		loteImportacao.setUsuario(usuarios);
		loteImportacao.setStatus(1);
		loteImportacaoRepository.save(loteImportacao);

		for (Map<String, Object> valoresItemCamada : importacaoCreateDto.getLista()) {
		 			
			Geodado geodado = new Geodado();
			geodado.setAtividadeEconomica(null); // TODO: incluir depois	
			geodado.setCamada(camada);
			geodado.setDataHoraInsercao(DataHora.getDataHora());
			geodado.setInstituicaoFonte(instituicaoFonte);
			
		
			geodado.setMunicipio(municipio);		
			geodado.setLoteImportacao(loteImportacao);
			geodado.setUsuario(usuario);
			Geodado geodadoRet =   geodadoRepository.save(geodado);

			Map<String, Object> map = (new HashMap<String, Object>());
			map.putAll(valoresItemCamada);

			 /*boolean[] controle =   new boolean[campos.size()];
			 Arrays.fill(controle, false);*/
			 
			
			for (Map.Entry<String, Object> valor : map.entrySet()) {	
				
				Campo campo =  getCampoCamada(valor.getKey(), campos);
		 
				if(campo != null) {
					if(campo.getTipoCampo().getNome().contains("Latitude")) {
						geodado.setLatitude(valor.getValue().toString());
						geodadoRepository.save(geodado);
					}
					
					if(campo.getTipoCampo().getNome().contains("Longitude")) {
						geodado.setLongitude(valor.getValue().toString());
						geodadoRepository.save(geodado);
					}
				}
						
			
				
				
				if(campo != null) {
									
					ValorCampo valorCampo = new ValorCampo();
					valorCampo.setSituacao(1);
					valorCampo.setCampo(campo);
					valorCampo.setValor(valor.getValue().toString());
					valorCampo.setGeodado(geodado);
					ValorCampoRepository.save(valorCampo);
					System.out.print(valor.getKey() + ": " + valor.getValue()+ "; ");
				}								
			}
			
			System.out.println("-----------------------------------------------------------------------");
		}

	}

	public Campo getCampoCamada(String nomeCampo, List<Campo> campos) {
		for (Campo campo : campos) {
			if (campo.getNome().contains(nomeCampo))
				return campo;
		}
		return null;
	}

}// endClass
