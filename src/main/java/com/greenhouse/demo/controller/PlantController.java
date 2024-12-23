package com.greenhouse.demo.controller;

import com.greenhouse.demo.entity.Plant;
import com.greenhouse.demo.service.PlantService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/plant")
public class PlantController {

    //@Autowired
    private final PlantService plantService;
    // Constructor Injection
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addPlant(@RequestBody Plant plant) {
        System.out.println(plant);
        try{
            System.out.println(plant);
            Plant addedPlant = plantService.createPlant(plant);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedPlant);
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    // GET all plants
    @GetMapping("/all")
    public ResponseEntity<List<Plant>> getAllPlants() {
        List<Plant> plants = plantService.getAllPlants();
        if (plants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(plants);
    }
    // GET plant by unique plantCode
    @GetMapping("/code/{plantCode}")
    public ResponseEntity<?> getPlantByCode(@PathVariable String plantCode) {
        Optional<Plant> plant = plantService.getPlantByCode(plantCode);
        if (plant.isPresent()) {
            return ResponseEntity.ok(plant.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plant not found with code: " + plantCode);
        }
    }
    // Update plant by plantCode
    @PutMapping("/update/{plantCode}")
    public ResponseEntity<Plant> updatePlant(@PathVariable String plantCode, @RequestBody Plant plant) {
        try {
            Plant updatedPlant = plantService.updatePlant(plantCode, plant);
            return ResponseEntity.ok(updatedPlant);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @DeleteMapping("/delete/{plantCode}")
    public ResponseEntity<?> deletePlantByCode(@PathVariable String plantCode) {
        try {
            plantService.deletePlantByCode(plantCode);
            return ResponseEntity.ok("Plant with code " + plantCode + " has been deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
