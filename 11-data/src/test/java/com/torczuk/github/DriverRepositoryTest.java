package com.torczuk.github;

import com.torczuk.github.domain.Driver;
import com.torczuk.github.domain.DriverRepository;
import org.assertj.core.util.Streams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DriverRepositoryTest {

    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void shouldFindAllDrivers() {
        Iterable<Driver> all = driverRepository.findAll();

        assertThat(Streams.stream(all).map(Driver::getName).collect(toList()))
                .contains("M Schumacher", "S. Vettl");
    }
}
