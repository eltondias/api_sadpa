package org.sadpa.repositories;

import org.sadpa.models.Campo;
import org.sadpa.models.CampoInserido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
 
public interface CampoInseridoRepository extends JpaRepository<CampoInserido, String> {
	
	CampoInserido findByIdCampoInserido(int idCampoInserido);	
	
	@Query("select ci from CampoInserido ci where ci.campo = :campo and ci.valor = :valor")
	CampoInserido findByCamposInseridos( @Param("campo") Campo campo, @Param("valor") String valor );
	
}
