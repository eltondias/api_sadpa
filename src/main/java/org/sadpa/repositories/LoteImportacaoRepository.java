package org.sadpa.repositories;

 
import org.sadpa.models.LoteImportacao;
import org.springframework.data.jpa.repository.JpaRepository;
 
 
public interface LoteImportacaoRepository extends JpaRepository<LoteImportacao, String> {
	
	LoteImportacao findByIdLoteImportacao(int idLoteImportacao);	  
	
}
