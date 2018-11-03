package com.torczuk.github;

import com.michellin.car.component.Tire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public Tire tire() {
        return new Tire("testing-tire");
    }

}
