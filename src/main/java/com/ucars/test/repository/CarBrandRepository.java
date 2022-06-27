package com.ucars.test.repository;

import com.ucars.test.dto.CarModelDto;
import com.ucars.test.model.CarBrand;
import com.ucars.test.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, Integer> {
    CarBrand findByName(String name);

}
