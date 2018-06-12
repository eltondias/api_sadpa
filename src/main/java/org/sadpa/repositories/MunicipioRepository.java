package org.sadpa.repositories;

import java.util.List;

import org.sadpa.models.Estado;
import org.sadpa.models.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MunicipioRepository extends JpaRepository<Municipio, String> {

	Municipio findByIdMunicipio(int idMunicipio);
	
	@Query("select m from Municipio m where  LOWER(TRANSLATE(m.nome,'ÀÁÃáàãÉÈéèÍíÓóÒòÕõÚúÑñ','AAAaaaEEeeIiOoOoOoUuNn')) LIKE LOWER(TRANSLATE(concat('%',:filtro,'%'),'ÀÁÃáàãÉÈéèÍíÓóÒòÕõÚúÑñçÇ','AAAaaaEEeeIiOoOoOoUuNncC')) and m.estado = 14 order by m.nome asc")
	List<Municipio> filtrar(@Param("filtro") String filtro);
	
	@Query("select m from Municipio m where m.estado = :estado ")
	Iterable<Municipio> findByEstado(@Param("estado") Estado estado);
 
}
