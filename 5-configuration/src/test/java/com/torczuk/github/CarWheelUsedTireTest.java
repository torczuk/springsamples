package com.torczuk.github;

import com.michellin.car.component.Tire;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class, TestConfig.class, CarWheelUsedTireTest.Config.class})
public class CarWheelUsedTireTest {

    @Autowired
    CarWheel carWheel;

    @Test
    public void shouldAutowireTire() {
        assertThat(carWheel.tire().model()).isEqualTo("used-tire");
    }

    public static class Config {
        @Bean
        public Tire tire() {
            return new Tire("used-tire");
        }
    }
}