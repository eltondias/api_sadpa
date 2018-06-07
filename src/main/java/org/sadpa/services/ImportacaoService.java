package org.sadpa.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.sadpa.dto.ImportacaoCreateDto;
import org.sadpa.models.Camada;
import org.sadpa.models.Campo;
import org.sadpa.models.CampoInserido;
import org.sadpa.models.Geodado;
import org.sadpa.models.InstituicaoFonte;
import org.sadpa.models.ItemCamada;
import org.sadpa.models.LoteImportacao;
import org.sadpa.models.Municipio;
import org.sadpa.models.Usuario;
import org.sadpa.repositories.CamadaRepository;
import org.sadpa.repositories.CampoInseridoRepository;
import org.sadpa.repositories.CampoRepository;
import org.sadpa.repositories.GeodadoRepository;
import org.sadpa.repositories.InstituicaoFonteRepository;
import org.sadpa.repositories.ItemCamadaRepository;
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
	private ItemCamadaRepository itemCamadaRepository;

	@Autowired
	private CampoInseridoRepository campoInseridoRepository;

	public void importar(ImportacaoCreateDto importacaoCreateDto) throws Exception {

		Camada camada = camadaRepository.findByIdCamada(importacaoCreateDto.getIdCamada());
		List<Campo> campos = campoRepository.findByCamada(camada);
		Usuario usuario = usuarioRepository.findByIdUsuario(importacaoCreateDto.getIdUsuario());
		Municipio municipio = municipioRepository.findByIdMunicipio(importacaoCreateDto.getIdMunicipio());
		InstituicaoFonte instituicaoFonte = instituicaoFonteRepository.findByIdInstituicaoFonte(importacaoCreateDto.getIdInstituicaoFonte());

		LoteImportacao loteImportacao = new LoteImportacao();
		loteImportacao.setDataHora(DataHora.getDataHora());
		loteImportacao.setUsuario(usuario);
		loteImportacao.setStatus(1);
		loteImportacaoRepository.save(loteImportacao);

		for (Map<String, Object> valoresItemCamada : importacaoCreateDto.getLista()) {
		 			
			ItemCamada itemCamada = new ItemCamada();
			itemCamada.setCamada(camada);
			itemCamadaRepository.save(itemCamada);

			Geodado geodado = new Geodado();
			geodado.setAtividadeEconomica(null); // TODO: incluir depois		
			geodado.setDataHoraInsercao(DataHora.getDataHora());
			geodado.setInstituicaoFonte(instituicaoFonte);
			geodado.setMunicipio(municipio);
			geodado.setItemCamada(itemCamada);
			geodado.setLoteImportacao(loteImportacao);
			geodado.setUsuario(usuario);
			geodadoRepository.save(geodado);

			Map<String, Object> map = (new HashMap<String, Object>());
			map.putAll(valoresItemCamada);

			 /*boolean[] controle =   new boolean[campos.size()];
			 Arrays.fill(controle, false);*/
			 
			
			for (Map.Entry<String, Object> valorCampo : map.entrySet()) {	
				
				Campo campo =  getCampoCamada(valorCampo.getKey(), campos);
			
				//campoInseridoRepository.findByCamposInseridos(campo,  valorCampo.getValue().toString());
				
				
				if(campo != null) {
									
					CampoInserido campoInserido = new CampoInserido();
					campoInserido.setAtivo(true);
					campoInserido.setCampo(campo);
					campoInserido.setValor(valorCampo.getValue().toString());
					campoInserido.setItemCamada(itemCamada);
					campoInseridoRepository.save(campoInserido);
					System.out.print(valorCampo.getKey() + ": " + valorCampo.getValue()+ "; ");
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
