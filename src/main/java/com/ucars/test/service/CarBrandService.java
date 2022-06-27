package com.ucars.test.service;

import com.ucars.test.model.CarBrand;

import java.util.List;
import java.util.Optional;

public interface CarBrandService {
    public List<CarBrand> getAllBrand();
    public Optional<CarBrand> getBrand(Integer id);
    public CarBrand createBrand(CarBrand carBrand);
    public void updateBrand(Integer id, CarBrand carBrand);
    public void deleteBrand(Integer id);
}
