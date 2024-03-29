package org.sadpa.repositories;

import org.sadpa.models.Regionalizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionalizacaoRepository extends JpaRepository<Regionalizacao, String> {

	Regionalizacao findByIdRegionalizacao(int idRegionalizacao);
	Iterable<Regionalizacao> findBySituacao(int situacao);
	
}
