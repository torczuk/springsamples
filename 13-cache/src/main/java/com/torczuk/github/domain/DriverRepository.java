package com.torczuk.github.domain;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver, Long> {

    List<Driver> findByName(String name);

    @Cacheable(cacheNames = "driver-names")
    default List<Driver> findByNameCachable(String name) {
        System.out.println("Find by name - " + name);
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return findByName(name);
    }
}
