package com.driveeasy.service;

import com.driveeasy.model.Vehicle;
import com.driveeasy.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServices {

    private final VehicleRepository repo;

    public VehicleServices(VehicleRepository repo) {
        this.repo = repo;
    }

    public Vehicle save(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {

        Vehicle existing =
                repo.findById(id).orElse(null);

        if (existing != null) {

            existing.setName(vehicle.getName());
            existing.setType(vehicle.getType());
            existing.setPricePerDay(vehicle.getPricePerDay());
            existing.setStatus(vehicle.getStatus());

            return repo.save(existing);
        }

        return null;
    }

    public void deleteVehicle(Long id) {

        repo.deleteById(id);
    }
}