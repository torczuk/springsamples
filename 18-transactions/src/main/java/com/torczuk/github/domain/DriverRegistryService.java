package com.torczuk.github.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class DriverRegistryService {
    @Autowired
    public DriverRepository driverRepository;
    @Autowired
    public DrivingLicenceRepository drivingLicenceRepository;

    @Transactional
    public DrivingLicence registerDriver(String name) {
        DrivingLicence drivingLicence = new DrivingLicence(UUID.randomUUID().toString());
        DrivingLicence registeredDrivingLicence = drivingLicenceRepository.save(drivingLicence);

//        for (int i = 0; i < 100; i++) {
//            drivingLicenceRepository.save(new DrivingLicence(UUID.randomUUID().toString()));
//        }

        Driver driver = new Driver(name, registeredDrivingLicence);
        driverRepository.save(driver);
//        if (true) {
//            throw new NullPointerException();
//        }
        return registeredDrivingLicence;
    }

}
