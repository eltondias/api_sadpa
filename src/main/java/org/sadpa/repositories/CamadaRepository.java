package org.sadpa.repositories;

import java.util.List;

import org.sadpa.models.Camada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamadaRepository extends JpaRepository<Camada, String> {
	
	Camada findByIdCamada(int idCamada);
	List<Camada> findByNome(String nome);
	Iterable<Camada> findBySituacao(int situacao);
	
}
