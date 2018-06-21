package org.sadpa.repositories;

import org.sadpa.models.Campo;
import org.sadpa.models.Geodado;
import org.sadpa.models.ValorCampo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
 
public interface ValorCampoRepository extends JpaRepository<ValorCampo, String> {
	
	ValorCampo findByIdValorCampo(int idValorCampo);	
	
	@Query("select v from ValorCampo v where v.campo = :campo and v.valor = :valor")
	ValorCampo findByValoresInseridos( @Param("campo") Campo campo, @Param("valor") String valor );
	
	 Iterable<ValorCampo> findByGeodado(Geodado geodado);
	
}
