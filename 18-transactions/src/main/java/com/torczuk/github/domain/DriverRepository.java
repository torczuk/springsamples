package com.torczuk.github.domain;

import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Long> {

    Driver findByName(String name);
}
