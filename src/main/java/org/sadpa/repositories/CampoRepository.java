package org.sadpa.repositories;

import java.util.List;
import org.sadpa.models.Camada;
import org.sadpa.models.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CampoRepository extends JpaRepository<Campo, String> {
	
	  Campo findByIdCampo(int IdCampo);
	
	  List<Campo> findByCamada(Camada camada);
	  
	  @Query("select c from Campo c where c.camada = :camada and  c.situacao between 0 and :situacao order by c.nome")
	  List<Campo> findByCamadaAndSituacao(
			  @Param("camada") Camada camada,
              @Param("situacao") int situacao
             );
	  
	
}
