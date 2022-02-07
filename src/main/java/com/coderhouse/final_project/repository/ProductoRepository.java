package com.coderhouse.final_project.repository;


import com.coderhouse.final_project.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ProductoRepository extends MongoRepository<Producto, String > {

    Producto findByCode(int code);

    List<Producto> getProductosByCategory(String category);

    void deleteProductoByCode(int code);


}