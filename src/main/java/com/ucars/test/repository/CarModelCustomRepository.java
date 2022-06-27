package com.ucars.test.repository;

import com.ucars.test.model.CarModel;

import java.util.List;

public interface CarModelCustomRepository {
    public List<CarModel> findByNameOrDescription(String name, String description);
}
