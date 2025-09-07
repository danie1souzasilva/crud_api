package br.com.crud.crud_api.repository;

import br.com.crud.crud_api.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
