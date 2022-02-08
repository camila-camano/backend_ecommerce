package com.coderhouse.final_project.repository;

import com.coderhouse.final_project.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findUserByEmail(String email);

}
