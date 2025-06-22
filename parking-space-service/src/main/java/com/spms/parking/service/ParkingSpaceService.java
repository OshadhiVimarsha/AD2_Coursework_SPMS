package com.spms.parking.service;

import com.spms.parking.entity.ParkingSpace;

import java.util.List;
import java.util.Optional;

public interface ParkingSpaceService {
    public List<ParkingSpace> getAllParkingSpaces();

    public Optional<ParkingSpace> getParkingSpaceById(Long id);

    public List<ParkingSpace> getAvailableParkingSpaces();

    public List<ParkingSpace> getParkingSpacesByOwner(String ownerId);

    public ParkingSpace createParkingSpace(ParkingSpace parkingSpace);

    public ParkingSpace updateParkingSpace(Long id, ParkingSpace parkingSpace);

    public boolean deleteParkingSpace(Long id);

    public ParkingSpace reserveParkingSpace(Long id, String vehicleId);

    public ParkingSpace releaseParkingSpace(Long id);
}
