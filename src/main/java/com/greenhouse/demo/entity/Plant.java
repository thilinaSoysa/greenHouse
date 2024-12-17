package com.greenhouse.demo.entity;
//package com.Student_info.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "Plants") // Name of the MySQL table
public class Plant {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment Primary Key
    @Column(name = "plant_id")
    private Long plantId;

    @Column(name = "plant_name", nullable = false, length = 100)
    private String plantName;

    @Column(name = "plant_type", nullable = false, length = 50)
    private String plantType;

    @Column(name = "soil_type", nullable = false, length = 50)
    private String soilType;

    @Column(name = "temperature_range", nullable = false, length = 50)
    private String temperatureRange;

    @Column(name = "humidity_range", nullable = false, length = 50)
    private String humidityRange;

    @Column(name = "light_requirement", nullable = false, length = 50)
    private String lightRequirement;

    @Column(name = "watering_frequency", nullable = false, length = 50)
    private String wateringFrequency;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    // Constructors
    public Plant() {
    }

    public Plant(String plantName, String plantType, String soilType, String temperatureRange,
                 String humidityRange, String lightRequirement, String wateringFrequency,
                 LocalDateTime lastUpdated) {
        this.plantName = plantName;
        this.plantType = plantType;
        this.soilType = soilType;
        this.temperatureRange = temperatureRange;
        this.humidityRange = humidityRange;
        this.lightRequirement = lightRequirement;
        this.wateringFrequency = wateringFrequency;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "plantId=" + plantId +
                ", plantName='" + plantName + '\'' +
                ", plantType='" + plantType + '\'' +
                ", soilType='" + soilType + '\'' +
                ", temperatureRange='" + temperatureRange + '\'' +
                ", humidityRange='" + humidityRange + '\'' +
                ", lightRequirement='" + lightRequirement + '\'' +
                ", wateringFrequency='" + wateringFrequency + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}