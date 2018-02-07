package org.sadpa.services;

import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.sadpa.constants.Situacao;
import org.sadpa.dto.RegiaoCreateDto;
import org.sadpa.dto.RegiaoUpdateDto;
import org.sadpa.models.Regiao;
import org.sadpa.repositories.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegiaoService {
	 
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Calendar dataAtual = Calendar.getInstance();

	@Autowired
	private RegiaoRepository regiaoRepository;

	public Regiao cadastrar(RegiaoCreateDto regiaoCreateDto) {			
		Regiao regiao =  modelMapper.map(regiaoCreateDto, Regiao.class);								
		regiao.setSituacao(Situacao.ATIVO);
		regiao.setDataHoraInsercao(dataAtual);		 
		return  regiaoRepository.save(regiao);
	} 
	
	public Regiao atualizar(RegiaoUpdateDto regiaoUpdateDto) {		
		Regiao regiao =  modelMapper.map(regiaoUpdateDto, Regiao.class);								
		regiao.setSituacao(regiaoUpdateDto.getSituacao());
		regiao.setDataHoraAtualizacao(dataAtual);		 
		return  regiaoRepository.save(regiao);
	} 
		
	public Regiao excluir(int idRegiao) {		
		Regiao regiao =  regiaoRepository.findByIdRegiao(idRegiao);							
		regiao.setSituacao(Situacao.EXCLUIDO);
		regiao.setDataHoraExclusao(dataAtual);		 
		return  regiaoRepository.save(regiao);
	} 
	
	public Regiao obter(int idRegiao) {		
		return regiaoRepository.findByIdRegiao(idRegiao);		 
	} 
		
	public Iterable<Regiao> listar() {		
		return regiaoRepository.findAll();		 
	} 
	
	public Iterable<Regiao> listarPorSituacao(int situacao) {		
		return regiaoRepository.findBySituacao(situacao);
	} 
	
}
