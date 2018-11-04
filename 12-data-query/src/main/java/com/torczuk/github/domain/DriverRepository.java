package com.torczuk.github.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver, Long> {

    List<Driver> findByName(String name);

    List<Driver> findByAddressCity(String city);

}
