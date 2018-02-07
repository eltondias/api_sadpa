package org.sadpa.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.sadpa.constants.Situacao;
import org.sadpa.dto.RegionalizacaoCreateDto;
import org.sadpa.dto.RegionalizacaoUpdateDto;
import org.sadpa.models.Regiao;
import org.sadpa.models.Regionalizacao;
import org.sadpa.repositories.EstadoRepository;
import org.sadpa.repositories.RegiaoRepository;
import org.sadpa.repositories.RegionalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionalizacaoService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	 
	@Autowired
	private RegionalizacaoRepository regionalizacaoRepository;
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Regionalizacao cadastrar(RegionalizacaoCreateDto regionalizacaoCreateDto) {		
		Regionalizacao regionalizacao =  modelMapper.map(regionalizacaoCreateDto, Regionalizacao.class);
		regionalizacao.setDataHoraInsercao(Calendar.getInstance());
		regionalizacao.setSituacao(Situacao.ATIVO);
		regionalizacaoRepository.save(regionalizacao);
		
		List<Regiao> regioes = new ArrayList<Regiao>();
		
		for (Regiao regiao : regionalizacao.getRegiao()) {			
			regioes.add(regiaoRepository.findByIdRegiao(regiao.getIdRegiao()));
		}
		
		regionalizacao.setEstado(estadoRepository.findByIdEstado(regionalizacaoCreateDto.getEstado().getIdEstado()));
		regionalizacao.setRegiao(regioes);
		
		return regionalizacao;	
	}
	
	public Regionalizacao obter(int idRegionalizacao) {			
		return regionalizacaoRepository.findByIdRegionalizacao(idRegionalizacao);		
	}
	
	public Regionalizacao atualizar(RegionalizacaoUpdateDto regionalizacaoUpdateDto) {					
		Regionalizacao regionalizacaoAtual = regionalizacaoRepository.findByIdRegionalizacao(regionalizacaoUpdateDto.getIdRegionalizacao());		
		Regionalizacao regionalizacao =  modelMapper.map(regionalizacaoUpdateDto, Regionalizacao.class);		
		regionalizacao.setDataHoraAtualizacao(Calendar.getInstance());	
		regionalizacao.setDataHoraInsercao(regionalizacaoAtual.getDataHoraInsercao());
		return regionalizacaoRepository.save(regionalizacao);		
	}

	public Regionalizacao excluir(int idRegionalizacao) {
		Regionalizacao regionalizacao = regionalizacaoRepository.findByIdRegionalizacao(idRegionalizacao);
		regionalizacao.setDataHoraExclusao(Calendar.getInstance());
		regionalizacao.setSituacao(Situacao.EXCLUIDO);
		return regionalizacaoRepository.save(regionalizacao);
	}
		
	public Iterable<Regionalizacao> listar() throws Exception {		
		return regionalizacaoRepository.findAll();
	}
	
	public Iterable<Regionalizacao> listarPorSituacao(int situacao) throws Exception {		
		return regionalizacaoRepository.findBySituacao(situacao);
	}
	
}
