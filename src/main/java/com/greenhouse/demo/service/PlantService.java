package com.greenhouse.demo.service;
import com.greenhouse.demo.entity.Plant;

import java.util.List;
import java.util.Optional;


public interface PlantService {

    Plant createPlant(Plant plant);
    // GET all plants
    List<Plant> getAllPlants();  // Add this method

    // GET plant by unique plantCode
    Optional<Plant> getPlantByCode(String plantCode);  // Already added
}
