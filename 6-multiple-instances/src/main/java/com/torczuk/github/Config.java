package com.torczuk.github;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.AliasFor;

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

}
