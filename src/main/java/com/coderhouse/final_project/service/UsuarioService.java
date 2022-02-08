package com.coderhouse.final_project.service;

import com.coderhouse.final_project.model.documents.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario createUser(String email, String pwd) throws Exception;

    Usuario getUserToken(String email, String pwd) throws Exception;

    List<Usuario> getAll();
}
