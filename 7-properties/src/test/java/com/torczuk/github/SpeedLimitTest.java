package com.torczuk.github;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpeedLimitTest {

    @Autowired
    Car car;

    @Test
    public void greetingShouldReturnDefaultMessage() {
        int maxSpeed = car.maxSpeed();
        Assertions.assertThat(maxSpeed).isLessThanOrEqualTo(200);
    }
}