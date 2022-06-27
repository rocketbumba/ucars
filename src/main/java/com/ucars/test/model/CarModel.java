package com.ucars.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "car_model")
@NoArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer model_id;

    private String name;
    private String description;

    private Integer brand_id;

    public CarModel(Integer model_id, String name, String description, Integer brand_id) {
        this.model_id = model_id;
        this.name = name;
        this.description = description;
        this.brand_id = brand_id;
    }
}
