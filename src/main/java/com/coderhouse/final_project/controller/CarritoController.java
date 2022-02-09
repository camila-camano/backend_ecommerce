package com.coderhouse.final_project.controller;


import com.coderhouse.final_project.model.documents.Carrito;
import com.coderhouse.final_project.model.documents.CodeStock;
import com.coderhouse.final_project.service.CarritoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coderhouse/carrito")
public class CarritoController {

    @Autowired
    CarritoService service;

    @PutMapping("/add")
    public List<CodeStock> addToCart(@RequestParam String email, @RequestParam int code, @RequestParam int stock){
        log.info("Agregando al carrito de {} el producto de código {} con stock a comprar {}.", email, code, stock);
        return service.addToCart(email, code, stock);
    }

    @GetMapping("/view")
    public Carrito view(@RequestParam String email){
        log.info("Mostrando todo el carrito de {}", email);
        return service.viewCart(email);
    }

    @PutMapping("/")
    public String updateStock(@RequestParam String email, @RequestParam int code, @RequestParam int stock){
        log.info("Modificando stock de un producto.");
        return service.updateCart(email, code, stock);
    }

    @DeleteMapping("/")
    public String deleteProduct(@RequestParam String email, @RequestParam int code){
        log.info("Eliminado un producto del carrito.");
        return service.deleteFromCart(email, code);
    }

}
