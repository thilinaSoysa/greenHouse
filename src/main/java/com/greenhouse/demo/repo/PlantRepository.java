package com.greenhouse.demo.repo;

import com.greenhouse.demo.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepo extends JpaRepository<Plant, Integer> {
}
