package com.torczuk.github.domain;

import org.springframework.data.repository.CrudRepository;

public interface DrivingLicenceRepository extends CrudRepository<DrivingLicence, Long> {

    DrivingLicence findByRef(String ref);
}
