package com.torczuk.github;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, properties = {"override-by=SpringBootTest"})
@TestPropertySource(properties = {"override-by=TestPropertySource"})
public class OverridePropertyTest {

    static {
        System.setProperty("override-by", "System.Property");
    }

    @Value("${override-by}")
    private String guess;

    @Test
    public void shouldPreferTestPropertySource() {
        String expected = null;
        Assertions.assertThat(guess).isEqualTo(expected);
    }
}
