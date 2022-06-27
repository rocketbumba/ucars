package com.ucars.test.service.impl;

import com.ucars.test.exception.InvalidInputException;
import com.ucars.test.exception.ResourceNotFoundException;
import com.ucars.test.model.CarBrand;
import com.ucars.test.repository.CarBrandRepository;
import com.ucars.test.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarBrandService {

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Override
    public List<CarBrand> getAllBrand() {
        return carBrandRepository.findAll();
    }

    @Override
    public Optional<CarBrand> getBrand(Integer id) {
        Optional<CarBrand> carBrand = carBrandRepository.findById(id);
        if(carBrand.isPresent()) {
            return carBrand;
        }
        else throw new ResourceNotFoundException("ResourceNotFound");
    }

    @Override
    public CarBrand createBrand(CarBrand carBrand) {
        if(carBrand.getName().isEmpty() || carBrand == null) {
            throw new InvalidInputException("Invalid Input");
        }

        if(carBrandRepository.findByName(carBrand.getName()) != null ) {
            throw new InvalidInputException("Invalid Input");
        }

        return carBrandRepository.save(carBrand);
    }

    @Override
    public void updateBrand(Integer id, CarBrand carBrand) {

        if(carBrand.getName().isEmpty() || carBrand == null) {
            throw new InvalidInputException("Invalid Input");
        }

        CarBrand temp = carBrandRepository.findById(id).orElse(null);
        if(temp == null) {
            throw new ResourceNotFoundException("ResourceNotFound");
        }

        temp.setName(carBrand.getName());
        temp.setDescription(carBrand.getDescription());
        carBrandRepository.save(temp);
    }

    @Override
    public void deleteBrand(Integer id) {
        CarBrand temp = carBrandRepository.findById(id).orElse(null);

        if(temp == null) {
            throw new ResourceNotFoundException("ResourceNotFound");
        }
        carBrandRepository.delete(temp);
    }
}
