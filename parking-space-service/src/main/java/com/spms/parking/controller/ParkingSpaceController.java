package com.spms.parking.controller;

import com.spms.parking.entity.ParkingSpace;
import com.spms.parking.service.impl.ParkingSpaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceServiceImpl parkingSpaceService;

    @GetMapping
    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceService.getAllParkingSpaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpace> getParkingSpaceById(@PathVariable Long id) {
        return parkingSpaceService.getParkingSpaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/available")
    public List<ParkingSpace> getAvailableParkingSpaces() {
        return parkingSpaceService.getAvailableParkingSpaces();
    }
/*
    @GetMapping("/zone/{zone}")
    public List<ParkingSpace> getParkingSpacesByZone(@PathVariable String zone) {
        return parkingSpaceService.getParkingSpacesByZone(zone);
    }*/

    @GetMapping("/owner/{ownerId}")
    public List<ParkingSpace> getParkingSpacesByOwner(@PathVariable String ownerId) {
        return parkingSpaceService.getParkingSpacesByOwner(ownerId);
    }

    @PostMapping
    public ParkingSpace createParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        return parkingSpaceService.createParkingSpace(parkingSpace);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpace> updateParkingSpace(
            @PathVariable Long id,
            @RequestBody ParkingSpace parkingSpace) {
        ParkingSpace updated = parkingSpaceService.updateParkingSpace(id, parkingSpace);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpace(@PathVariable Long id) {
        return parkingSpaceService.deleteParkingSpace(id) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    /*@PostMapping("/{id}/reserve")
    public ResponseEntity<ParkingSpace> reserveParkingSpace(
            @PathVariable Long id,
            @RequestParam String vehicleId) {
        ParkingSpace reserved = parkingSpaceService.reserveParkingSpace(id, vehicleId);
        return reserved != null ? ResponseEntity.ok(reserved) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/{id}/release")
    public ResponseEntity<ParkingSpace> releaseParkingSpace(@PathVariable Long id) {
        ParkingSpace released = parkingSpaceService.releaseParkingSpace(id);
        return released != null ? ResponseEntity.ok(released) : ResponseEntity.badRequest().build();
    }*/
} 