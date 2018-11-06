package com.torczuk.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    @Autowired // try to remove
    private Engine engine;

    @Autowired// try to remove
    public Car(@Autowired Engine engine) { // try to remove
        System.out.println("by args constructor");
        this.engine = engine;
    }

    public Car() {
        System.out.println("by no-args constructor");
    }

    @Override
    public void drive() {
    }

    public boolean isFast() {
        return engine.hpPower() > 200;
    }

    @Autowired
    public void setEngine(Engine engine) {
        System.out.println("by setter");
        this.engine = engine;
    }
}
