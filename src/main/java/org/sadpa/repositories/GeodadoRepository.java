package org.sadpa.repositories;

import org.sadpa.models.Geodado;
import org.springframework.data.jpa.repository.JpaRepository;
 
 
public interface GeodadoRepository extends JpaRepository<Geodado, String> {
	
	Geodado findByIdGeodado(int idGeodado);	  
	
}
