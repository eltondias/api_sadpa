package org.sadpa.repositories;

 
import org.sadpa.models.ItemCamada;
import org.springframework.data.jpa.repository.JpaRepository;
 
 
public interface ItemCamadaRepository extends JpaRepository<ItemCamada, String> {
	
	ItemCamada findByIdItemCamada(int idItemCamada);	  
	
}
