package com.coderhouse.final_project.controller;


import com.coderhouse.final_project.service.OrdenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/coderhouse/carrito")
public class OrdenController {

    @Autowired
    OrdenService service;

    @PostMapping("/order")
    public String createOrder(@RequestParam String email){
        log.info("Creando orden de {} .", email );
        return service.createOrder(email);
    }

}
