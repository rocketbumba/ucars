package com.ucars.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarBrandDto {
    private Integer brand_id;

    private String name;

    private String description;

    public CarBrandDto(Integer brand_id, String name, String description) {
        this.brand_id = brand_id;
        this.name = name;
        this.description = description;
    }
}
