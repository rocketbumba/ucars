package com.ucars.test.specifications;

import com.ucars.test.model.CarModel;
import com.ucars.test.model.CarModel_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CarModelSprcification {
    public static Specification<CarModel> hasName(String name) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(CarModel_.NAME), "%" + name + "%"
            );
        });
    }

    public static Specification<CarModel> hasDescription(String description) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(CarModel_.DESCRIPTION), "%" + description + "%"
            );
        });
    }
}
