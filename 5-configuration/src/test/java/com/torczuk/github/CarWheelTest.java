package com.torczuk.github;

import com.michellin.car.component.Tire;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CarWheelTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    Tire tire;

    @Autowired
    CarWheel carWheel;

    @Test
    public void shouldAutowireTire() {
        assertThat(tire).isNotNull();
        assertThat(tire.model()).isEqualTo("all seasons");
    }

    @Test
    public void shouldVerifyEqualityBetweenTireAndCarWheelTire() {
        assertThat(carWheel).isNotNull();
        assertThat(carWheel.tire()).isEqualTo(tire);
    }

    @Test
    public void shouldVerifyEqualityBetweenTireAndTireTakenFromContext() {
        assertThat(context.getBean(Tire.class)).isEqualTo(tire);
    }
}