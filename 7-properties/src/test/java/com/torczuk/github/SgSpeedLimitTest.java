package com.torczuk.github;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("sg")
public class SgSpeedLimitTest {

    @Autowired
    Car car;

    @Test
    public void greetingShouldReturnDefaultMessage() {
        int maxSpeed = car.maxSpeed();
        Assertions.assertThat(maxSpeed).isLessThanOrEqualTo(100);
    }
}