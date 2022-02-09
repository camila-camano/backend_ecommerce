package com.coderhouse.final_project.service.implementation;


import com.coderhouse.final_project.model.documents.Carrito;
import com.coderhouse.final_project.model.documents.CodeStock;
import com.coderhouse.final_project.model.documents.Producto;
import com.coderhouse.final_project.repository.CarritoRepository;
import com.coderhouse.final_project.repository.ProductoRepository;
import com.coderhouse.final_project.service.CarritoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class CarritoServiceImpl implements CarritoService {

    //setup
    @Autowired
    private CarritoRepository repository;

    @Autowired
    private MongoTemplate template;

    // create
    @Override
    public List<CodeStock> addToCart(String email, int code, int stock) {

        var producto = CodeStock.builder().code(code).stock(stock).build();

        var carrito = repository.findByEmail(email);
        if(carrito == null ){
            List<CodeStock> lista = new ArrayList();
            Date date = new Date(System.currentTimeMillis());
            carrito = Carrito.builder()
                    .email(email)
                    .products(lista)
                    .createDate(date)
                    .build();
            repository.save(carrito);
        }
        var productosDelCarrito = carrito.getProducts();
        productosDelCarrito.add(productosDelCarrito.size(), producto);
        carrito.setProducts(productosDelCarrito);
        repository.save(carrito);
        return carrito.getProducts();

    }

    // get
    @Override
    public Carrito viewCart(String email){
        return repository.findByEmail(email);
    }

    //update
    @Override
    public String updateCart(String email, int code, int stock) {

        var carrito = repository.findByEmail(email);
        var productos = carrito.getProducts();

        for( CodeStock cs : productos){
            if (Objects.equals(cs.getCode(), code)){
                cs.setStock(stock);
                return ("El producto " + code + " ha sido modificado, nuevo stock a comprar:" + stock);
            }
        }

        return "El ID no existe en el carrito.";

    }

    //delete
    @Override
    public String deleteFromCart(int code, int stock) {
        return null;
    }

}
