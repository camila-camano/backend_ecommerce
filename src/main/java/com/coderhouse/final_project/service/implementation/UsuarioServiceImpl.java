package com.coderhouse.final_project.service.implementation;


import com.coderhouse.final_project.model.documents.Usuario;
import com.coderhouse.final_project.model.exceptions.ApiRestTokenException;
import com.coderhouse.final_project.repository.UsuarioRepository;
import com.coderhouse.final_project.security.JwtProvider;
import com.coderhouse.final_project.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final JwtProvider jwtProvider;

    @Autowired
    private MongoTemplate template;



    @Override
    public Usuario createUser(String email, String pwd) throws Exception{
        Usuario user = Usuario.builder().email(email).pwd(pwd).build();
        return repository.save(user);
    }


    @Override
    public Usuario getUserToken(String email, String pwd) throws Exception {
        var user = repository.findUserByEmail(email);

        if(user == null){
            throw new ApiRestTokenException("El usuario no existe.");
        }
        if (!(user.getEmail().equals(email) && user.getPwd().equals(pwd))) {
            throw new ApiRestTokenException("El usuario o el password es inválido.");
        }
       var token = jwtProvider.getJWTToken(email);
       return Usuario.builder().email(email).token(token).build();
       // return user;
    }

    @Override
    public List<Usuario> getAll(){
        return repository.findAll();
    }
}

