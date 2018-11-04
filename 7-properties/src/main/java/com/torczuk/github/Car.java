package com.torczuk.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    @Value("${driving.limits.speed.max}")
    private int maxSpeed;

    @Autowired
    private final Engine engine;

    public Car(Engine engine) { // try to remove
        this.engine = engine;
    }

    @Override
    public void drive() {
        System.out.println("The best for comfort");
    }

    @Override
    public int maxSpeed() {
        int carLimit = engine.hpPower() * 2;
        return carLimit > maxSpeed ? maxSpeed : carLimit;
    }
}
