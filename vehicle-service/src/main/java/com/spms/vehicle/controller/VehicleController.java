package com.spms.vehicle.controller;

import com.spms.vehicle.entity.Vehicle;
import com.spms.vehicle.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @GetMapping("/getAll")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/users/{userId}")
    public List<Vehicle> getVehiclesByUserId(@PathVariable String userId) {
        return vehicleService.getVehiclesByUserId(userId);
    }

    @PostMapping("/save")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle savedVehicle = vehicleService.createVehicle(vehicle);
            return ResponseEntity.ok(savedVehicle);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicle> updateVehicle(
            @PathVariable Long id,
            @RequestBody Vehicle vehicle) {
        Vehicle updated = vehicleService.updateVehicle(id, vehicle);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteVehicle(@PathVariable Long id) {
        if (vehicleService.deleteVehicle(id)) {
            return ResponseEntity.ok(Map.of("message", "Delete successful"));
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Vehicle not found"));
        }
    }


    @PutMapping("/update/{id}/parking-space/{parkingSpaceId}")
    public ResponseEntity<Vehicle> updateParkingSpace(
            @PathVariable Long id,
            @PathVariable Long parkingSpaceId) {
        Vehicle updated = vehicleService.updateParkingSpace(id, parkingSpaceId);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("delete/{id}/parking-space")
    public ResponseEntity<Vehicle> removeFromParkingSpace(@PathVariable Long id) {
        Vehicle updated = vehicleService.removeFromParkingSpace(id);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
} 