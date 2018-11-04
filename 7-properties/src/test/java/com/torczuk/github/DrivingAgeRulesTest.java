package com.torczuk.github;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DrivingAgeRulesTest {

    @Autowired
    DrivingAgeRules rules;

    @Test
    public void shouldVerifyIfDriverIsOldEnough() {
        Assertions.assertThat(rules.getMax()).isEqualTo(80);
        Assertions.assertThat(rules.getMin()).isEqualTo(20);
    }
}
