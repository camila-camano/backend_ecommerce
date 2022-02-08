package com.coderhouse.final_project.controller;


import com.coderhouse.final_project.model.documents.Producto;
import com.coderhouse.final_project.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coderhouse/productos")
public class ProductoController {

    @Autowired
    ProductoService service;

    //Posts
    @PostMapping("/post")
    public Producto createProducto(@RequestBody Producto p){
        log.info("POST request recibido, creando producto: " + p.getName() + ".");
        return service.createProducto(p);
    }

    //Gets
    @GetMapping("getbyid")
    public Producto getProducto(@RequestParam int code){
        log.info("GET BY ID request recibido. Producto de código: " + code);
        return service.getByCode(code);
    }

    @GetMapping("/getall")
    public List<Producto> getAll(){
        log.info("GET ALL request recibido. Todos los productos.");
        return  service.getAll();
    }

    @GetMapping("/getbycategory")
    public List<Producto> getByCategory(@RequestParam String category){
        log.info("GET ALL BY CATEGORY request recibido. Productos de categoria: " + category);
        return  service.getSameCategory(category);
    }

    //Updates
    @PutMapping("/put/stock")
    public void updateStock(@RequestParam int code, int stock){
        log.info("PUT STOCK request recibido. Producto de código: {} con nuevo precio {}", code,stock);
        service.updateStockOf(code,stock);
    }

    @PutMapping("/put/price")
    public void updatePrice(@RequestParam int code, int price){
        log.info("PUT STOCK request recibido. Producto de código: {} con nuevo precio {}", code, price);
        service.updateStockOf(code,price);
    }


    //Deletes
    @DeleteMapping("/delete")
    public void delete(@RequestParam int code){
        log.info("DELETE request recibido. Borrando producto de código:" + code);
        service.deleteByCode(code);
    }

}
