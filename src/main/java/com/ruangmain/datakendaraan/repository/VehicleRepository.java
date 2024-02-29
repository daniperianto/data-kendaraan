package com.ruangmain.datakendaraan.repository;

import com.ruangmain.datakendaraan.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

    @Query("SELECT v FROM vehicles v WHERE v.id ILIKE %:id% AND v.name ILIKE %:name%")
    Iterable<Vehicle> search(String id, String name);
}
