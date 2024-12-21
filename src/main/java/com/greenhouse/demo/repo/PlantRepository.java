package com.greenhouse.demo.repo;

import com.greenhouse.demo.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PlantRepository extends JpaRepository<Plant, String> {

   Optional<Plant> getByPlantCode(String plantCode);
}
