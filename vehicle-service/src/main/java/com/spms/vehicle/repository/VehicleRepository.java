package com.spms.vehicle.repository;

import com.spms.vehicle.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByUserId(String userId);
    List<Vehicle> findByCurrentParkingSpaceId(Long parkingSpaceId);
    Vehicle findByLicensePlate(String licensePlate);
} 