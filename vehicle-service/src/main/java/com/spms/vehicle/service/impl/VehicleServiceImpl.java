package com.spms.vehicle.service.impl;

import com.spms.vehicle.entity.Vehicle;
import com.spms.vehicle.repository.VehicleRepository;
import com.spms.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public List<Vehicle> getVehiclesByUserId(String userId) {
        return vehicleRepository.findByUserId(userId);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        if (vehicleRepository.existsById(id)) {
            vehicle.setId(id);
            return vehicleRepository.save(vehicle);
        }
        return null;
    }

    public boolean deleteVehicle(Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Vehicle updateParkingSpace(Long id, Long parkingSpaceId) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            vehicle.setCurrentParkingSpaceId(parkingSpaceId);
            return vehicleRepository.save(vehicle);
        }
        return null;
    }

    public Vehicle removeFromParkingSpace(Long id) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            vehicle.setCurrentParkingSpaceId(null);
            return vehicleRepository.save(vehicle);
        }
        return null;
    }
} 