package com.spms.vehicle.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String userId;

    @Column
    private Long currentParkingSpaceId;
}