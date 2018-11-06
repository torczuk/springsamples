package com.torczuk.github;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class BeanInQualifierCarTest {

    @Autowired(required = false)
    @Qualifier("slow")
    Car another;

    @Test
    public void autowireSlowByQualifier() {
        assertThat(another).isNotNull();
    }
}
