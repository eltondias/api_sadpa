package org.sadpa.repositories;

import org.sadpa.models.Campo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampoRepository extends JpaRepository<Campo, String> {
	
	Campo findByIdCampo(int idCamada);
	
}
