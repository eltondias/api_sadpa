package org.sadpa.repositories;

 
import org.sadpa.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Usuario findByIdUsuario(int idUsuario);
	
	
	@Query("select u from Usuario u where u.situacao = :situacao order by login asc")
	Iterable<Usuario> findBySituacao(			
            @Param("situacao") int situacao       
           );
	
 
	
}
