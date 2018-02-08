package org.sadpa.repositories;

import org.sadpa.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Usuario findByIdUsuario(int idUsuario);
	Iterable<Usuario> findBySituacao(int situacao);
	
}
