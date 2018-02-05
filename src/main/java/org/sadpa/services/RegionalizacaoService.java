package org.sadpa.services;

import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.sadpa.constants.Situacao;
import org.sadpa.dto.RegionalizacaoCreateDto;
import org.sadpa.models.Regionalizacao;
import org.sadpa.repositories.RegionalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionalizacaoService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Calendar dataAtual = Calendar.getInstance();

	@Autowired
	private RegionalizacaoRepository regionalizacaoRepository;
	
	public Regionalizacao cadastrarRegionalizacao(RegionalizacaoCreateDto regionalizacaoCreateDto) {		
		Regionalizacao regionalizacao =  modelMapper.map(regionalizacaoCreateDto, Regionalizacao.class);
		regionalizacao.setDataHoraInsercao(dataAtual);
		regionalizacao.setSituacao(Situacao.ATIVO);
		regionalizacaoRepository.save(regionalizacao);
		return regionalizacao;	
	}

}
