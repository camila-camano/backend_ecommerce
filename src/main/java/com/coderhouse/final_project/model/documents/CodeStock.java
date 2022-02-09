package com.coderhouse.final_project.model.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CodeStock {
    private int code;
    private int stock;
}
