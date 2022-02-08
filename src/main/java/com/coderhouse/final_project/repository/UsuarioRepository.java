package com.coderhouse.final_project.repository;

import com.coderhouse.final_project.model.documents.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

/*
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findUserByEmail(String email);

}


 */


public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

    Usuario findUserByEmail(String email);

}