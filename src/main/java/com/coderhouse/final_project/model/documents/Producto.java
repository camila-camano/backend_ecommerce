package com.coderhouse.final_project.model.documents;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productos")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Producto {

    @Id
    private String id;

    @Indexed(unique=true)
    private int code;

    private String name;

    private String category;
    private String description;

    private int price;
    private int stock;


}
