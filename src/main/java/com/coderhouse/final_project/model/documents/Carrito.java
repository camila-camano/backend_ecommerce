package com.coderhouse.final_project.model.documents;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("carritos")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Carrito {

    @Id
    private String id;

    @Indexed(unique=true)
    private String email;
    private List<CodeStock> products;
    private Date  createDate;

}
