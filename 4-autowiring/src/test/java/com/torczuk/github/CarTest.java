package com.torczuk.github;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CarTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    private Vehicle vehicle;

    @Autowired(required = false)
    private String thisBeanDoesNotExist;

    @Test
    public void shouldAutowireAppContext() {
        assertThat(context).isNotNull();
    }

    @Test
    public void shouldAutowireVehicle() {
        assertThat(vehicle).isNotNull();
    }

    @Test
    public void shouldNotAutowireNonExistingBean() {
        assertThat(thisBeanDoesNotExist).isNull();
    }
}