package com.torczuk.github;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Bean
    @Qualifier("mercedes")
    public Car fast() {
        return new Car(new Engine(150));
    }

    @Bean
    @Qualifier("seat")
    public Car slow() {
        return new Car(new Engine(120));
    }

    @Bean
    @Primary
    public Car slow(Engine engine) {
        return new Car(engine);
    }
}
