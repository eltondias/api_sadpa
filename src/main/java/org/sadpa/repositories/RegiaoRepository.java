package org.sadpa.repositories;


import org.sadpa.models.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegiaoRepository extends JpaRepository<Regiao, String> {

	
	Regiao findByIdRegiao(int idRegiao);
	
	@Query("select r from Regiao r where r.situacao = :situacao order by nome asc")
	Iterable<Regiao> findBySituacao(			
            @Param("situacao") int situacao       
           );
	//Iterable<Regiao> findBySituacao(int situacao);
}
