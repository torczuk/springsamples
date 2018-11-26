package com.torczuk.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Car implements Vehicle {

    @Autowired
    private BrokenEngine engine;

    @Override
    public void drive() {
        engine.start();
    }

    public void switchLight() {
        System.out.println("Lights on");
    }

    public String serialNumber() {
        return UUID.randomUUID().toString();
    }
}
