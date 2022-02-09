package com.coderhouse.final_project.service;

import com.coderhouse.final_project.model.documents.Carrito;
import com.coderhouse.final_project.model.documents.CodeStock;
import com.coderhouse.final_project.model.documents.Producto;
import org.bson.types.Code;

import java.util.List;

public interface CarritoService {

    List<CodeStock> addToCart(String email, int code, int stock);

    Carrito viewCart(String email);

    String updateCart(String email, int code, int stock);

    String deleteFromCart(String email, int code);

}
