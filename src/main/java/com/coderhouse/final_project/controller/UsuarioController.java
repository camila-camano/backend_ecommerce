package com.coderhouse.final_project.controller;


import com.coderhouse.final_project.model.Usuario;
import com.coderhouse.final_project.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/coderhouse")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping("user/login")
    public Usuario login(@RequestParam("user") String email, @RequestParam("password") String pwd) throws Exception {
        return service.getUser(email, pwd);
    }

}
