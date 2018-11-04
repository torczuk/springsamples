package com.torczuk.github;

import com.torczuk.github.domain.Driver;
import com.torczuk.github.domain.DriverRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DriverRepositoryTest {

    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void shouldInsertDriver() {
        Driver driver = new Driver(";)");
        driverRepository.save(driver);

        assertThat(driverRepository.findAll()).contains(driver);
    }

    @Test
    public void shouldDeleteDriver() {
        Driver driver = new Driver(":]");
        driverRepository.save(driver);

        assertThat(driverRepository.findAll()).contains(driver);

        driverRepository.delete(driver);

        assertThat(driverRepository.findAll()).doesNotContain(driver);
    }

}
