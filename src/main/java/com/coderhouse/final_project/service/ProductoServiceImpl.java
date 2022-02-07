package com.coderhouse.final_project.service;


import com.coderhouse.final_project.model.Producto;
import com.coderhouse.final_project.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Autowired
    private MongoTemplate template;

    //create
    @Override
    public Producto createProducto(Producto producto) {
        return repository.save(producto);
    }

    //request
    @Override
    public Producto getByCode(int code) {
        return repository.findByCode(code);
    }

    @Override
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Producto> getSameCategory(String category) {
        return repository.getProductosByCategory(category);
    }

    //update
    @Override
    public void updateStockOf(int code, int stock) {
        var query = new Query();
        query.addCriteria(Criteria.where("code").is(code));
        var update = new Update();
        update.set("stock", stock);
        template.updateFirst(query, update, Producto.class);
    }

    @Override
    public void updatePriceOf(int code, int price) {
        var query = new Query();
        query.addCriteria(Criteria.where("code").is(code));
        var update = new Update();
        update.set("price", price);
        template.updateFirst(query, update, Producto.class);

    }

    //delete
    @Override
    public void deleteByCode(int code) {
        repository.deleteProductoByCode(code);
    }


}
