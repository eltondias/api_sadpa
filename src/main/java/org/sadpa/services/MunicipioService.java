package org.sadpa.services;

import java.util.List;

import org.sadpa.models.Estado;
import org.sadpa.models.Municipio;
import org.sadpa.repositories.EstadoRepository;
import org.sadpa.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {
	 
	@Autowired
	private MunicipioRepository municipioRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	 	 
	public Municipio obter(int idMunicipio) {		
		return municipioRepository.findByIdMunicipio(idMunicipio);
	} 
		
	public Iterable<Municipio> listar() {		
		return municipioRepository.findAll();		 
	} 
	
	
	public Iterable<Municipio> porEstado(int idEstado) {			
		Estado estado =  estadoRepository.findByIdEstado(idEstado);		
		return municipioRepository.findByEstado(estado);		 
	} 
	
	public List<Municipio> filtrar(String filtro) {	
		
		/*List<Municipio> listaMunicipios =  new ArrayList<Municipio>();
				
		for (Municipio municipio :  municipioRepository.filtrar(filtro))
		{ 
			municipio.setNome(municipio.getNome() + " - " + municipio.getEstado().getSigla()); 
			listaMunicipios.add(municipio);
		}*/
		
		  return municipioRepository.filtrar(filtro);
	} 
	
}
