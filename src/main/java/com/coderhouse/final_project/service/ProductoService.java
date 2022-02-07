package com.coderhouse.final_project.service;

import com.coderhouse.final_project.model.Producto;

import java.util.List;

public interface ProductoService {

    // Create
    Producto createProducto(Producto producto);

    // Request
    Producto getByCode(int code);

    List<Producto> getAll();
    List<Producto> getSameCategory(String category);

    // Update
    void updateStockOf(int code, int stock);
    void updatePriceOf(int code, int price);

    //Delete
    void deleteByCode(int code);




}
