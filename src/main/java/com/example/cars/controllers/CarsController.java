package com.example.cars.controllers;

import com.example.cars.model.Car;
import com.example.cars.repository.CarRepository;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {

  @Autowired
  private CarRepository carRepository;

  @GetMapping("/cool-cars")
  @CrossOrigin(origins = "http://localhost:4200")
  public Collection<Car> coolCars() {
    return carRepository.findAll().stream()
        .filter(this::isCool)
        .collect(Collectors.toList());
  }

  private boolean isCool(Car car) {
    return !car.getName().equals("AMC Gremlin") &&
        !car.getName().equals("Triumph Stag") &&
        !car.getName().equals("Ford Pinto") &&
        !car.getName().equals("Yugo GV");
  }
}
