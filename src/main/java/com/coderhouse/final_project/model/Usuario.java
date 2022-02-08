package com.coderhouse.final_project.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("usuarios")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Usuario {

    @Id
    private String id;
    private String email;
    private String password;
    private String token;

}
