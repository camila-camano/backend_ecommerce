package com.coderhouse.final_project.service;


import com.coderhouse.final_project.model.Usuario;
import com.coderhouse.final_project.model.exceptions.ApiRestTokenException;
import com.coderhouse.final_project.repository.UsuarioRepository;
import com.coderhouse.final_project.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final JwtProvider jwtProvider;

    @Override
    public Usuario getUser(String email, String pwd) throws Exception {
        var user = repository.findUserByEmail(email);

        if (!(user.getEmail().equals(email) && user.getPassword().equals(pwd))) {
            throw new ApiRestTokenException("El usuario o el password es inválido");
        }
        var token = jwtProvider.getJWTToken(email);
        return Usuario.builder().email(email).token(token).build();
    }
}

