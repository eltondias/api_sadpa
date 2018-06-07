package org.sadpa.repositories;

 
import org.sadpa.models.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipioRepository extends JpaRepository<Municipio, String> {

	Municipio findByIdMunicipio(int idMunicipio);
 
}
