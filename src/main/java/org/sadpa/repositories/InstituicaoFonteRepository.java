package org.sadpa.repositories;
 
import org.sadpa.models.InstituicaoFonte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituicaoFonteRepository extends JpaRepository<InstituicaoFonte, String> {
	
	InstituicaoFonte  findByIdInstituicaoFonte(int  idInstituicaoFonte);
	InstituicaoFonte  findByCnpj(String cnpj);
	Iterable<InstituicaoFonte> findBySituacao(int situacao);
}
