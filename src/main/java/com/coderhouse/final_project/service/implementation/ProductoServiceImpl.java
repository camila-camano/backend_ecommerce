package com.coderhouse.final_project.service.implementation;


import com.coderhouse.final_project.cache.CacheClient;
import com.coderhouse.final_project.model.documents.Producto;
import com.coderhouse.final_project.repository.ProductoRepository;
import com.coderhouse.final_project.service.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Slf4j
@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    //setup
    @Autowired
    private ProductoRepository repository;

    @Autowired
    private MongoTemplate template;

    private final CacheClient<Producto> cache;

    //create
    @Override
    public Producto createProducto(Producto producto) {
        try {
                var data = repository.save(producto);
                return saveMessageInCache(data);

        } catch (JsonProcessingException e) {
            log.error("Error convirtiendo producto a string.", e);
        }
        return producto;
    }

    //request
    @Override
    public Producto getByCode(int code) {

        try {
            var dataFromCache = cache.recover(String.valueOf(code), Producto.class);
            if (!Objects.isNull(dataFromCache)) {
                return dataFromCache;
            }
            var dataFromDatabase = repository.findByCode(code);
            if(dataFromDatabase == null){
                log.error("El ID no existe.");
                return null;
            }
            return saveMessageInCache(dataFromDatabase);
        } catch (JsonProcessingException e){
            log.error("Error converting message to string", e);
        }
        return null;
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


    //cache utils --------------------
    private Producto saveMessageInCache(Producto producto) throws JsonProcessingException {
        return cache.save(String.valueOf(producto.getCode()), producto);
    }



}
