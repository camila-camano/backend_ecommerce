package com.coderhouse.final_project.controller;


import com.coderhouse.final_project.model.documents.Usuario;
import com.coderhouse.final_project.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coderhouse")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    // POSTs
    @PostMapping("user/register")
    public Usuario register(@RequestParam String email, String pwd) throws Exception {
        log.info("Registrando usuario: " + email + " ,con password: " + pwd + "...");
        return service.createUser(email,pwd);
    }

    @PostMapping("user/login")
    public Usuario login(@RequestParam String email, @RequestParam String pwd) throws Exception {
        log.info("Adquiriendo token...");
        return service.getUserToken(email, pwd);
    }

    //GETs
    @GetMapping("/user/all")
    public List<Usuario> getAll(){
        log.info("Adquiriendo todos los usuarios...");
        return service.getAll();
    }

}
