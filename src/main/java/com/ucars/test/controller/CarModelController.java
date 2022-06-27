package com.ucars.test.controller;

import com.ucars.test.dto.CarModelDto;
import com.ucars.test.model.CarModel;
import com.ucars.test.repository.CarModelRepository;
import com.ucars.test.service.CarModelService;
import com.ucars.test.specifications.CarModelSprcification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CarModelRepository carModelRepository;

    @GetMapping("/model")
    public ResponseEntity<List<CarModelDto>> getAllModel() {
        List<CarModel> carModels = carModelService.getAllModel();
        List<CarModelDto> carModelDtos = carModels.stream().map(carModel -> mapper.map(carModel, CarModelDto.class)).collect(Collectors.toList());
        return new ResponseEntity<List<CarModelDto>>(carModelDtos, HttpStatus.OK);
    }

    @GetMapping("/model/")
    public ResponseEntity<CarModelDto> getModel(@RequestParam Integer model_id) {
        CarModel carModel = carModelService.getCarModel(model_id);
        CarModelDto carModelDto = mapper.map(carModel, CarModelDto.class);
        return new ResponseEntity<CarModelDto>(carModelDto, HttpStatus.OK);
    }

    @GetMapping("/model/brand")
    public ResponseEntity<List<CarModelDto>> fetchAllByBrand(@RequestParam String name) {
        List<CarModel> carModels = carModelService.getModelByName(name);
        List<CarModelDto> carModelDtos = carModels.stream().map(carModel -> mapper.map(carModel, CarModelDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(carModelDtos, HttpStatus.OK);
    }

    @GetMapping("/model/{name}/{description}")
    public ResponseEntity<List<CarModelDto>> findByNameAndDescription(@PathVariable("name") String name, @PathVariable("description") String description) {

        Specification<CarModel> specification = Specification.where(CarModelSprcification.hasName(name).and(
                CarModelSprcification.hasDescription(description)));

        List<CarModel>  carModels = carModelRepository.findAll(specification);
        List<CarModelDto> carModelDtos = carModels.stream().map(carModel -> mapper.map(carModel, CarModelDto.class)).collect(Collectors.toList());
        return new ResponseEntity<List<CarModelDto>>(carModelDtos, HttpStatus.OK);
    }

    @PostMapping("/model")
    public ResponseEntity<String> createModel(@RequestBody CarModel carModel) {
        CarModel carModel1 = carModelService.createCarModel(carModel);
        return new ResponseEntity<String>("Create Success", HttpStatus.OK);
    }

    @PutMapping("/model")
    public ResponseEntity<String> updateModel(@RequestBody CarModel carModel) {
        carModelService.updateCarMode(carModel);
        return new ResponseEntity<>("Update Success", HttpStatus.OK);
    }

    @DeleteMapping("/model")
    public ResponseEntity<String> deleteModel(@RequestParam Integer model_id) {
        carModelService.deleteCarModel(model_id);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }

}
