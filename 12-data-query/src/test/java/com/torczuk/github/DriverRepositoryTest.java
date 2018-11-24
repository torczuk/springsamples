package com.torczuk.github;

import com.torczuk.github.domain.Address;
import com.torczuk.github.domain.Driver;
import com.torczuk.github.domain.DriverRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DriverRepositoryTest {

    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void shouldFindDriverByName() {
        List<Driver> result = driverRepository.findByName("M Schumacher");

        assertThat(result)
                .hasSize(1)
                .contains(new Driver("M Schumacher", new Address("Berlin")));
    }

    @Test
    public void shouldFindDriverByCityName() {
        List<Driver> result = driverRepository.findByAddressCity("Munich");

        assertThat(result)
                .hasSize(1)
                .contains(new Driver("S. Vettl", new Address("Munich")));
    }

    @Test
    public void shouldFindTopLevelDriver() {
        List<Driver> result = driverRepository.findTopDriver();

        assertThat(result)
                .hasSize(1)
                .contains(new Driver("M Schumacher", new Address("Berlin")));
    }


    @Test
    public void shouldFindTopLevelDriver2() {
        List<String> integers = driverRepository.findDriverWhereNameLengthIsGraterThan(2);

    }
}
