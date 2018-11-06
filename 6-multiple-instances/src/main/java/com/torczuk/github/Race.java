package com.torczuk.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Race {

    private Car firstCar;
    private Car secondCar;

    @Autowired
    public Race(Car firstCar, Car secondCar) {
        this.firstCar = firstCar;
        this.secondCar = secondCar;
    }

    public Car winner() {
        return firstCar.maxSpeed() > secondCar.maxSpeed() ? firstCar : secondCar;
    }
}

