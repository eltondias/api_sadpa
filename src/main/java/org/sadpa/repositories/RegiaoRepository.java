package org.sadpa.repositories;

 
import org.sadpa.models.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegiaoRepository extends JpaRepository<Regiao, String> {

	Regiao findByIdRegiao(int idRegiao);
	Iterable<Regiao> findBySituacao(int situacao);
}
