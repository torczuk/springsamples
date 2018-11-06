package com.torczuk.github;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Car implements Vehicle {

    private Engine engine;

    @Override
    public void drive() {
    }

    public boolean isFast() {
        return engine.hpPower() > 200;
    }

    @PostConstruct
    public void init() {
        System.out.println("Car has been created");
//        System.out.println("Is my car fast enough? :" + isFast());
    }
}
