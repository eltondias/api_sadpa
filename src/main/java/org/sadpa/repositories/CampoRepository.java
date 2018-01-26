package org.sadpa.repositories;

import java.util.List;
import org.sadpa.models.Camada;
import org.sadpa.models.Campo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampoRepository extends JpaRepository<Campo, String> {
	
	  Campo findByIdCampo(int IdCampo);
	
	  List<Campo> findByCamada(Camada camada);
	
}
