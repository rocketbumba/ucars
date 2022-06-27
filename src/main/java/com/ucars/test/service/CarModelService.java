package com.ucars.test.service;

import com.ucars.test.model.CarModel;

import java.util.List;

public interface CarModelService {
    public List<CarModel> getAllModel();
    public CarModel getCarModel(Integer id);
    public CarModel createCarModel(CarModel carModel);
    public CarModel updateCarMode(CarModel carModel);
    public void deleteCarModel(Integer model_id);

    public List<CarModel> getModelByName(String name);
}
