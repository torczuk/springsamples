package com.torczuk.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    @Lazy
    @Autowired
    private BrokenEngine engine;

    @Override
    public void drive() {
        engine.start();
    }

    public void switchLight() {
        System.out.println("Lights on");
    }
}
