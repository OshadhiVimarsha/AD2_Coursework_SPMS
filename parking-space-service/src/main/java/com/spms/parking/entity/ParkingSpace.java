package com.spms.parking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parking_spaces")
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;


    @Column(nullable = false)
    private boolean isAvailable;

    @Column(nullable = false)
    private double hourlyRate;

    @Column(nullable = false)
    private String ownerId;

    @Column
    private String currentVehicleId;
} 