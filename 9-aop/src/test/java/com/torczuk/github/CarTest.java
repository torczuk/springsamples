package com.torczuk.github;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
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
    public void shouldNotWorkCauseEngineIsBroken() {
        expectedException.expect(IllegalStateException.class);
        car.drive();
    }

    @Test
    public void shouldMonitorAccessToCar() {
        String serialNumber = car.serialNumber();

        Assertions.assertThat(serialNumber).isNotNull();
    }

    @Test
    public void shouldUserProxyInsteadOfRealClass() {
        //because of @EnableAspectJAutoProxy(proxyTargetClass = true)
        //put breakpoint here and take a look of car properties
        Assertions.assertThat(car.getClass()).isNotEqualTo(Car.class);
    }
}