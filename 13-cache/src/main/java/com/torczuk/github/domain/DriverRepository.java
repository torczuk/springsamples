package com.torczuk.github.domain;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver, Long> {
    long TWO_SECONDS = 2_000;

    List<Driver> findByName(String name);

    @Cacheable(cacheNames = "driver-names")
    default List<Driver> findByNameCacheable(String name) {
        System.out.println("Find by name - " + name);
        try {
            Thread.sleep(TWO_SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return findByName(name);
    }
}
