package com.ucars.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarModelDto {
    private Integer model_id;
    private String name;
    private String description;
    private Integer brand_id;

    public CarModelDto(Integer model_id, String name, String description, Integer brand_id) {
        this.model_id = model_id;
        this.name = name;
        this.description = description;
        this.brand_id = brand_id;
    }
}
