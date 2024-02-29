package com.ruangmain.datakendaraan.service;

import com.ruangmain.datakendaraan.model.Vehicle;
import com.ruangmain.datakendaraan.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository repository;

    public Iterable<Vehicle> findAll() {
        return repository.findAll();
    }

    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Vehicle edit(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public void delete(Vehicle vehicle) {
        repository.delete(vehicle);
    }

    public Optional<Vehicle> findById(String id) {
        return repository.findById(id);
    }

    public Iterable<Vehicle> search(String id, String name) {
        return repository.search(id, name);
    }
}

