package org.sadpa.repositories;

import org.sadpa.models.TipoCampo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCampoRepository extends JpaRepository<TipoCampo, String> {
	
	  TipoCampo findByIdTipoCampo(int IdTipoCampo);
	
}
