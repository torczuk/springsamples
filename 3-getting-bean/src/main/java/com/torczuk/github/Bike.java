package com.torczuk.github;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Fitness in the first place");
    }
}

