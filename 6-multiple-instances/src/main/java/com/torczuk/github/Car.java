package com.torczuk.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

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
        return engine.hpPower() * 2;
    }
}
