package com.coderhouse.final_project.service.implementation;

import com.coderhouse.final_project.model.documents.Orden;
import com.coderhouse.final_project.repository.CarritoRepository;
import com.coderhouse.final_project.repository.OrdenRepository;
import com.coderhouse.final_project.service.OrdenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrdenServiceImpl implements OrdenService {

    //setup
    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private MongoTemplate template;

    public String createOrder(String email){
        var productos = carritoRepository.findByEmail(email).getProducts();
        Date date = new Date(System.currentTimeMillis());
        var orden = Orden.builder()
                .orderNumber(ordenRepository.count())
                .productos(productos)
                .createDate(date)
                .email(email)
                .status("generada")
                .build();
        //agregar precio
        //limpiar carrito del usuario
        ordenRepository.save(orden);

        return "Orden generada con éxito. ";

    }

}
