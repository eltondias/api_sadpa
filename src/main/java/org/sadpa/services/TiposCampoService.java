package org.sadpa.services;

 
import org.sadpa.models.TipoCampo;
import org.sadpa.repositories.TipoCampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TiposCampoService {

	@Autowired
	private TipoCampoRepository tipoCampoRepository;
	
	public Iterable<TipoCampo> listar() throws Exception {
		
		Iterable<TipoCampo> listaTiposCampo = tipoCampoRepository.findAll();
						
		return listaTiposCampo;
	}
	
	
	public TipoCampo cadastrar(TipoCampo tipoCampo) throws Exception {

		try {
			
			return tipoCampoRepository.save(tipoCampo);
			
		} catch (Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}
	
	
	 
}
