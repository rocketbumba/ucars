package com.ucars.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "car_brand")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brand_id;

    private String name;

    private String description;

    public CarBrand(Integer brand_id, String name, String description) {
        this.brand_id = brand_id;
        this.name = name;
        this.description = description;
    }
}


