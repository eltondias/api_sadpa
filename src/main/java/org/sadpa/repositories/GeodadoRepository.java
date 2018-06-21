package org.sadpa.repositories;

import java.util.Calendar;
import java.util.List;

import org.sadpa.models.Camada;
import org.sadpa.models.Geodado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
 
public interface GeodadoRepository extends JpaRepository<Geodado, String> {
	
	Geodado findByIdGeodado(int idGeodado);	  
	
	//SELECT * FROM public.geodado where id_camada in (1,2,3) and id_municipio in (2436)
	
	@Query("select g from Geodado g where g.camada.idCamada IN (:camadas) and g.municipio.idMunicipio IN (:municipios) and g.dataHoraInsercao BETWEEN :dataInicial AND :dataFinal  order by g.camada.idCamada ")
	List<Geodado> geodadoMap(			
            @Param("camadas") List<Integer> camadas, 
            @Param("municipios") List<Integer> municipios, 
            @Param("dataInicial") Calendar dataInicial, 
            @Param("dataFinal") Calendar dataFinal
           );
	
	List<Geodado> findByCamada(Camada Camada);	 
	
}
