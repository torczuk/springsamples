package com.torczuk.github;

import org.springframework.stereotype.Component;

@Component
public class Engine {

    private final int hpPower;

    public Engine() {
        hpPower = 140;
    }

    public Engine(int hpPower) {
        this.hpPower = hpPower;
    }

    public int hpPower() {
        return hpPower;
    }


}
