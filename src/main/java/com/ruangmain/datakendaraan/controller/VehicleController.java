package com.ruangmain.datakendaraan.controller;

import com.ruangmain.datakendaraan.model.Vehicle;
import com.ruangmain.datakendaraan.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @GetMapping("/")
    public ResponseEntity<Iterable<Vehicle>> findAll() {
        Iterable<Vehicle> vehicles = service.findAll();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Vehicle> vehicle = service.findById(id);
        if(vehicle.isPresent()) {
            return ResponseEntity.ok(vehicle.get());
        } else {
            return ResponseEntity.badRequest().body("Vehicle Not Found");
        }

    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Vehicle>> add(@RequestParam String no, @RequestParam String name) {
        return ResponseEntity.ok(service.search(no, name));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicle1 = service.findById(vehicle.getId());
        if(vehicle1.isPresent()) {
            return ResponseEntity.badRequest().body("Id already exist!");
        } else {
            return ResponseEntity.ok(service.save(vehicle));
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> edit(@Valid @RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(service.edit(vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Vehicle> vehicle = service.findById(id);
        if(vehicle.isPresent()) {
            service.delete(vehicle.get());
            return ResponseEntity.ok("Vehicle Deleted Successfully");
        } else {
            return ResponseEntity.badRequest().body("Vehicle Not Found");
        }
    }
}
