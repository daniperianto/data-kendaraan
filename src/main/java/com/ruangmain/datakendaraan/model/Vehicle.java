package com.ruangmain.datakendaraan.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vehicles")
public class Vehicle {

    @Id
    @NotNull
    @NotEmpty
    private String id;

    @Nonnull
    @NotNull
    @NotEmpty
    private String name;

    private String address;
    private String brand;

    @Max(9999)
    private int year_created;

    private int capacity;

    @Pattern(regexp = "Merah|Hitam|Biru|Abu-Abu")
    private String color;

    private String fuel;
}
