package com.torczuk.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    @Autowired // try to remove
    private Engine engine;

    @Autowired// try to remove
    public Car(@Autowired Engine engine) { // try to remove
        this.engine = engine;
    }

    @Override
    public void drive() {
    }

    public boolean isFast() {
        return engine.hpPower() > 200;
    }

    @Autowired // try to remove
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
