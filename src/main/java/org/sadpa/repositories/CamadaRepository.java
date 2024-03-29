package org.sadpa.repositories;

import java.util.List;

import org.sadpa.models.Camada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CamadaRepository extends JpaRepository<Camada, String> {
	
	Camada findByIdCamada(int idCamada);
	
	@Query("select c from Camada c where  c.nome = :nome and c.situacao <> 3 ")
	List<Camada> findByNome(  @Param("nome") String nome);
	
	Iterable<Camada> findBySituacao(int situacao);
	
	@Query("select c from Camada c where c.situacao = :situacao order by idCamada asc")
	Iterable<Camada> findBySituacaoAndOrder(			
            @Param("situacao") int situacao       
           );
	  
	
}
