package org.sadpa.repositories;

import org.sadpa.models.Camada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamadaRepository extends JpaRepository<Camada, String> {
	
	Camada findByIdCamada(int idCamada);
	
}
