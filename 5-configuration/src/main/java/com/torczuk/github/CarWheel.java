package com.torczuk.github;

import com.michellin.car.component.Tire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarWheel {

    @Autowired
    private final Tire tire;

    public CarWheel(Tire tire) {
        this.tire = tire;
    }

    public Tire tire() {
        return tire;
    }
}
