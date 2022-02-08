package com.coderhouse.final_project.model.documents;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productos")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Producto {

    @Id
    private String id;
    private int code;
    private String name;

    private String category;
    private String description;

    private int price;
    private int stock;


}
