package com.ucars.test.controller;

import com.ucars.test.dto.CarBrandDto;
import com.ucars.test.model.CarBrand;
import com.ucars.test.service.CarBrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CarBrandController {

    @Autowired
    private CarBrandService carBrandService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/brand")
    public ResponseEntity<List<CarBrandDto>> getAllBrands(){
        List<CarBrand> carBrands = carBrandService.getAllBrand();
        List<CarBrandDto> carBrandDtos = carBrands.stream().map(carBrand -> mapper.map(carBrand, CarBrandDto.class)).collect(Collectors.toList());
        return new ResponseEntity<List<CarBrandDto>>(carBrandDtos, HttpStatus.OK);
    }

    @GetMapping("/brand/")
    public ResponseEntity<CarBrandDto> getBrand(@RequestParam Integer id) {
        CarBrand carBrand = carBrandService.getBrand(id).orElse(null);
        CarBrandDto carBrandDto = mapper.map(carBrand, CarBrandDto.class);
        return new ResponseEntity<CarBrandDto>(carBrandDto, HttpStatus.OK);
    }

    @PostMapping("/brand")
    public ResponseEntity<String> createBrand(@RequestBody CarBrand carBrand) {
        carBrandService.createBrand(carBrand);
        return new ResponseEntity<>("Create Success", HttpStatus.OK);
    }

    @PutMapping("/brand")
    public ResponseEntity<String> updateBrand(@RequestBody CarBrand carBrand) {
        Integer id = carBrand.getBrand_id();
        carBrandService.updateBrand(id, carBrand);
        return new ResponseEntity<String>("Update Success", HttpStatus.OK);
    }

    @DeleteMapping("/brand")
    public ResponseEntity<String> deleteBrand(@RequestParam Integer id) {
        carBrandService.deleteBrand(id);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}
