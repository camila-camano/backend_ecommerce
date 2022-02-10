package com.coderhouse.final_project.model.documents;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CodeStock {

    private int code;
    private int stock;

    @Override
    public String toString() {
        return
                "Código del producto: " + code +
                ", stock a comprar: " + stock ;
    }
}
