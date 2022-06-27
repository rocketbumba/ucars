package com.ucars.test.service.impl;

import com.ucars.test.dto.CarModelDto;
import com.ucars.test.exception.InvalidInputException;
import com.ucars.test.exception.ResourceNotFoundException;
import com.ucars.test.model.CarBrand;
import com.ucars.test.model.CarModel;
import com.ucars.test.repository.CarBrandRepository;
import com.ucars.test.repository.CarModelRepository;
import com.ucars.test.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CarModelServiceImpl implements CarModelService {

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Override
    public List<CarModel> getAllModel() {
        return carModelRepository.findAll();
    }

    @Override
    public CarModel getCarModel(Integer id) {

        LOGGER.log(Level.ALL, "Begin get CarModel");
        if(id == null) throw new InvalidInputException("InvalidInput");

        CarModel carModel = carModelRepository.findById(id).orElse(null);
        if(carModel == null) {
            throw new ResourceNotFoundException("ResourceNotFound");
        }

        LOGGER.log(Level.INFO, "Success get CarModel");
        return carModel;
    }

    @Override
    public CarModel createCarModel(CarModel carModel) {
        if(carModel.getName().isEmpty() || carModel == null) {
            throw new InvalidInputException("Invalid Input");
        }

        Integer brand_id = carModel.getBrand_id();
        if(carModelRepository.findModelByBrand(brand_id) == null) {
            throw new ResourceNotFoundException("ResourceNotFound");
        }

        return carModelRepository.save(carModel);
    }

    @Override
    public CarModel updateCarMode(CarModel carModel) {

        if(carModel == null) {
            throw new InvalidInputException("Invalid Input");
        }

        CarModel carModel1 = carModelRepository.findById(carModel.getModel_id()).orElse(null);
        if(carModel1 == null) {
            throw new ResourceNotFoundException("ResourceNotFound");
        }

        carModel1.setName(carModel.getName());
        carModel1.setDescription(carModel.getDescription());
        return carModelRepository.save(carModel1);
    }

    @Override
    public void deleteCarModel(Integer model_id) {
        CarModel carModel = carModelRepository.findById(model_id).orElse(null);
        if(carModel == null) {
            throw new ResourceNotFoundException("Invalid Input");
        }
        carModelRepository.delete(carModel);
    }

    @Override
    public List<CarModel> getModelByName(String name) {

        if(name == null) throw new InvalidInputException("Invalid Input");

        CarBrand carBrand = carBrandRepository.findByName(name);
        return carModelRepository.findModelByBrand(carBrand.getBrand_id());
    }

}
