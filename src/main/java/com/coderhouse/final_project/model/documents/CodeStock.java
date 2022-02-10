package com.coderhouse.final_project.model.documents;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class CodeStock {
    private int code;
    private int stock;
}
