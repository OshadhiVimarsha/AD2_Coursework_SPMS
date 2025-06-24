package com.spms.parking.service.impl;

import com.spms.parking.entity.ParkingSpace;
import com.spms.parking.repository.ParkingSpaceRepository;
import com.spms.parking.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceRepository.findAll();
    }

    public Optional<ParkingSpace> getParkingSpaceById(Long id) {
        return parkingSpaceRepository.findById(id);
    }

    public List<ParkingSpace> getAvailableParkingSpaces() {
        return parkingSpaceRepository.findByIsAvailable(true);
    }

    public ParkingSpace createParkingSpace(ParkingSpace parkingSpace) {
        return parkingSpaceRepository.save(parkingSpace);
    }

    public ParkingSpace updateParkingSpace(Long id, ParkingSpace parkingSpace) {
        if (parkingSpaceRepository.existsById(id)) {
            parkingSpace.setId(id);
            return parkingSpaceRepository.save(parkingSpace);
        }
        return null;
    }

    public boolean deleteParkingSpace(Long id) {
        if (parkingSpaceRepository.existsById(id)) {
            parkingSpaceRepository.deleteById(id);
            return true;
        }
        return false;
    }
} 