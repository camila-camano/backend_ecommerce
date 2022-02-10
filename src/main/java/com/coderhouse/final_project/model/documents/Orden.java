package com.coderhouse.final_project.model.documents;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("ordenes")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Orden {

    @Id
    private String id;

    private Long orderNumber;
    List<CodeStock> productos;
    private Date createDate;
    private String email;
    private String status;
}
