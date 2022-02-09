package com.coderhouse.final_project.repository;

import com.coderhouse.final_project.model.documents.Carrito;
import com.coderhouse.final_project.model.documents.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarritoRepository extends MongoRepository<Carrito, String > {

    Carrito findByEmail(String email);

}
