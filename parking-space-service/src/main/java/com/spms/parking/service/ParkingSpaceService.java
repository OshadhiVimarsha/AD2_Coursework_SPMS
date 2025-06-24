package com.spms.parking.service;

import com.spms.parking.entity.ParkingSpace;

import java.util.List;
import java.util.Optional;

public interface ParkingSpaceService {
    List<ParkingSpace> getAllParkingSpaces();

    Optional<ParkingSpace> getParkingSpaceById(Long id);

    List<ParkingSpace> getAvailableParkingSpaces();

    ParkingSpace createParkingSpace(ParkingSpace parkingSpace);

    ParkingSpace updateParkingSpace(Long id, ParkingSpace parkingSpace);

    boolean deleteParkingSpace(Long id);
}
