package com.spms.vehicle.service;

import com.spms.vehicle.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    public List<Vehicle> getAllVehicles();

    public Optional<Vehicle> getVehicleById(Long id);

    public List<Vehicle> getVehiclesByUserId(String userId);

    public Vehicle createVehicle(Vehicle vehicle);

    public Vehicle updateVehicle(Long id, Vehicle vehicle);

    public boolean deleteVehicle(Long id);

    public Vehicle updateParkingSpace(Long id, Long parkingSpaceId);

    public Vehicle removeFromParkingSpace(Long id);
}
