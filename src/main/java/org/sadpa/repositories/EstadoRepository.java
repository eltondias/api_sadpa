package org.sadpa.repositories;

 
import org.sadpa.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, String> {

	Estado findByIdEstado(int idEstado);
 
}
