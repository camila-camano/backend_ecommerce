package com.coderhouse.final_project.service.implementation;

import com.coderhouse.final_project.model.documents.CodeStock;
import com.coderhouse.final_project.model.documents.Orden;
import com.coderhouse.final_project.model.documents.Producto;
import com.coderhouse.final_project.repository.CarritoRepository;
import com.coderhouse.final_project.repository.OrdenRepository;
import com.coderhouse.final_project.repository.ProductoRepository;
import com.coderhouse.final_project.service.EmailService;
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
    private ProductoRepository productoRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private MongoTemplate template;

    public String createOrder(String email){

        // Consigo los productos del carrito y calculo el precio total.
        var productos = carritoRepository.findByEmail(email).getProducts();
        int price = 0;

        for(CodeStock cs : productos ){
            price += productoRepository.findByCode(cs.getCode()).getPrice() * cs.getStock();
        }

        //Armo la orden.
        Date date = new Date(System.currentTimeMillis());
        var orden = Orden.builder()
                .orderNumber(ordenRepository.count()+1)
                .productos(productos)
                .totalPrice(price)
                .createDate(date)
                .email(email)
                .status("generada")
                .build();

        // Guardo la orden.
        ordenRepository.save(orden);

        // Envio mail.
        emailService.sendEmail(orden);

        //Elimino el carrito.
        carritoRepository.delete(carritoRepository.findByEmail(email));

        return "Orden generada con éxito. Su carrito ha sido vaciado. Chequear mail para ver la confirmación. ";

    }

}
