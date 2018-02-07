package org.sadpa.services;


import java.util.Calendar;
import java.util.TimeZone;
import org.sadpa.constants.Situacao;
import org.sadpa.dto.InstituicaoFonteCreateDto;
import org.sadpa.dto.InstituicaoFonteUpdateDto;
import org.sadpa.models.InstituicaoFonte;
import org.sadpa.repositories.InstituicaoFonteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoFonteService {
	
	
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
	
	public InstituicaoFonte obter(int idInstituicaoFonte) throws Exception {	
		
		InstituicaoFonte instituicaoFonte = instituicaoFonteRepository.findByIdInstituicaoFonte(idInstituicaoFonte);
		
		if(instituicaoFonte.getSituacao() != Situacao.EXCLUIDO)		
			return instituicaoFonteRepository.findByIdInstituicaoFonte(idInstituicaoFonte);	
		else return null;
	}
	
	public InstituicaoFonte atualizar(InstituicaoFonteUpdateDto instituicaoFonteNova) throws Exception {			
		InstituicaoFonte instituicaoFonteAtual =  instituicaoFonteRepository.findByIdInstituicaoFonte(instituicaoFonteNova.getIdInstituicaoFonte());			
		instituicaoFonteAtual.setCnpj(instituicaoFonteNova.getCnpj());
		instituicaoFonteAtual.setDescricao(instituicaoFonteNova.getDescricao());
		instituicaoFonteAtual.setNome(instituicaoFonteNova.getNome());
		instituicaoFonteAtual.setDataHoraAtualizacao(dataAtual);		
		
		if(instituicaoFonteNova.getSituacao() !=  Situacao.EXCLUIDO)
			instituicaoFonteAtual.setSituacao(instituicaoFonteNova.getSituacao());
		
		
		return instituicaoFonteRepository.save(instituicaoFonteAtual);			 
	}
	
	public InstituicaoFonte excluir(int idInstituicaoFonte) throws Exception {			
		
		InstituicaoFonte instituicaoFonteAtual =  instituicaoFonteRepository.findByIdInstituicaoFonte(idInstituicaoFonte);			
		
		if(instituicaoFonteAtual != null) {		
			
			if(instituicaoFonteAtual.getSituacao() == Situacao.EXCLUIDO)
				throw new Exception("Instituição fonte já foi excluída"); 			
			
			instituicaoFonteAtual.setSituacao(Situacao.EXCLUIDO);
			instituicaoFonteAtual.setDataHoraExclusao(dataAtual);		
			return instituicaoFonteRepository.save(instituicaoFonteAtual);		 		
		}else  
			throw new Exception("Instituição fonte não existe"); 
	}
	
	public Iterable<InstituicaoFonte> listar() throws Exception {		 
		return instituicaoFonteRepository.findAll();	 
	}
	
	public Iterable<InstituicaoFonte> listarPorSituacao(int situacao ) throws Exception {
		
		Iterable<InstituicaoFonte> listarInstituicoes = instituicaoFonteRepository.findBySituacao(situacao);
						 
		return listarInstituicoes;
	}

}
