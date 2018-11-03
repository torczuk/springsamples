package com.torczuk.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleCatalog {

    private final List<Vehicle> vehicles;

    @Autowired // is it necessary?
    public VehicleCatalog(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
