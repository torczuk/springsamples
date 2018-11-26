package com.torczuk.github.domain;

import com.torczuk.github.Application;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DriverRegistryServiceTest {

    @Autowired
    private DriverRegistryService driverRegistryService;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private DrivingLicenceRepository drivingLicenceRepository;

    @Test
    public void shouldRegisterNewDriver() {
        String name = UUID.randomUUID().toString();

        DrivingLicence drivingLicence = driverRegistryService.registerDriver(name);

        Driver byName = driverRepository.findByName(name);
        Assertions.assertThat(byName.getDrivingLicence()).isEqualTo(drivingLicence);
    }

    @Test
    public void shouldRollbackTransactionInCaseOfException() {
        long driverCount = driverRepository.count();
        long licenceCount = drivingLicenceRepository.count();
        String name = UUID.randomUUID().toString();

        //ugly, but you can not continue test even with expected or @Rule
        try {
            driverRegistryService.registerDriver(name);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        long driverCountAfter = driverRepository.count();
        long licenceCountAfter = drivingLicenceRepository.count();
        Assertions.assertThat(driverCount).isEqualTo(driverCountAfter);
        Assertions.assertThat(licenceCount).isEqualTo(licenceCountAfter);

    }
}