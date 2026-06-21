package com.driveeasy.controller;

import com.driveeasy.model.Vehicle;
import com.driveeasy.service.VehicleServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleServices service;

    public VehicleController(VehicleServices service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return service.save(vehicle);
    }

    // READ
    @GetMapping
    public List<Vehicle> getVehicles() {
        return service.getAllVehicles();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Vehicle updateVehicle(
            @PathVariable Long id,
            @RequestBody Vehicle vehicle) {

        return service.updateVehicle(id, vehicle);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        service.deleteVehicle(id);
    }
}
