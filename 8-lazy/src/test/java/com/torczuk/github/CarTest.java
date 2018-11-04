package com.torczuk.github;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CarTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    Car car;

    @Test
    public void shouldWorkFineWhenLightsAreSwitching() {
        car.switchLight();
    }

    @Test
    public void shouldNotWorkCauseEngineIsBroken() {
        expectedException.expect(BeanCreationException.class);
        car.drive();
    }
}