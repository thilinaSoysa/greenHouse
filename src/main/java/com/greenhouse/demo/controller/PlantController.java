package com.greenhouse.demo.controller;

import com.greenhouse.demo.entity.Plant;
import com.greenhouse.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

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
}
