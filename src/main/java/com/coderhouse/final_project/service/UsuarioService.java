package com.coderhouse.final_project.service;

import com.coderhouse.final_project.model.Usuario;

public interface UsuarioService {
    Usuario getUser(String username, String pwd) throws Exception;
}
