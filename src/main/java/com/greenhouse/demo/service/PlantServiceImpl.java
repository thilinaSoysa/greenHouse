package com.greenhouse.demo.service;

import com.greenhouse.demo.entity.Plant;
import com.greenhouse.demo.repo.PlantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService{
    private static final Logger logger = LoggerFactory.getLogger(PlantServiceImpl.class);

    private final PlantRepository PlantRepo;

    public PlantServiceImpl(PlantRepository plantRepo) {
        this.PlantRepo = plantRepo;
    }

    @Override
    public Plant createPlant(Plant plant) {
        Optional<Plant> existingPlant = PlantRepo.getByPlantCode(plant.getPlantCode());
        if(existingPlant.isPresent()){
            throw new RuntimeException("A Plant with Index No :"+ plant.getPlantCode() +" already exists");
        }
        System.out.println(plant);
        return PlantRepo.save(plant);
    }
}
