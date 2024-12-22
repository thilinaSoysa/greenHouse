package com.greenhouse.demo.service;

import com.greenhouse.demo.entity.Plant;
import com.greenhouse.demo.repo.PlantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
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
    // GET all plants
    @Override
    public List<Plant> getAllPlants() {
        return PlantRepo.findAll();
    }

    // GET plant by unique plantCode
    @Override
    public Optional<Plant> getPlantByCode(String plantCode) {
        return PlantRepo.getByPlantCode(plantCode);
    }
    @Override
    public Plant updatePlant(String plantCode, Plant plant) {
        Optional<Plant> existingPlant = PlantRepo.getByPlantCode(plantCode);
        if (existingPlant.isPresent()) {
            Plant updatedPlant = existingPlant.get();
            updatedPlant.setPlantName(plant.getPlantName());
            updatedPlant.setPlantType(plant.getPlantType());
            updatedPlant.setSoilType(plant.getSoilType());
            updatedPlant.setTemperatureRange(plant.getTemperatureRange());
            updatedPlant.setHumidityRange(plant.getHumidityRange());
            updatedPlant.setLightRequirement(plant.getLightRequirement());
            updatedPlant.setWateringFrequency(plant.getWateringFrequency());
            updatedPlant.setLastUpdated(plant.getLastUpdated());

            return PlantRepo.save(updatedPlant);
        } else {
            throw new RuntimeException("Plant with code " + plantCode + " not found for update.");
        }
    }
    @Override
    public void deletePlantByCode(String plantCode) {
        Optional<Plant> existingPlant = PlantRepo.getByPlantCode(plantCode);
        if (existingPlant.isPresent()) {
            PlantRepo.delete(existingPlant.get());
        } else {
            throw new RuntimeException("Plant with code " + plantCode + " not found for deletion.");
        }
    }

}
