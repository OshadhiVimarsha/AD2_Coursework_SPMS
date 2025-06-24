package com.spms.parking.controller;

import com.spms.parking.entity.ParkingSpace;
import com.spms.parking.service.impl.ParkingSpaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking-space")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceServiceImpl parkingSpaceService;

    @GetMapping("/getAll")
    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceService.getAllParkingSpaces();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ParkingSpace> getParkingSpaceById(@PathVariable Long id) {
        return parkingSpaceService.getParkingSpaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/available")
    public List<ParkingSpace> getAvailableParkingSpaces() {
        return parkingSpaceService.getAvailableParkingSpaces();
    }

    @PostMapping("/save")
    public ParkingSpace createParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        return parkingSpaceService.createParkingSpace(parkingSpace);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ParkingSpace> updateParkingSpace(
            @PathVariable Long id,
            @RequestBody ParkingSpace parkingSpace) {
        ParkingSpace updated = parkingSpaceService.updateParkingSpace(id, parkingSpace);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteParkingSpace(@PathVariable Long id) {
        boolean deleted = parkingSpaceService.deleteParkingSpace(id);
        return deleted
                ? ResponseEntity.ok("Delete successful")
                : ResponseEntity.notFound().build();
    }

} 