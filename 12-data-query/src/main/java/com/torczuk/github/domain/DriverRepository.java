package com.torczuk.github.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver, Long> {

    List<Driver> findByName(String name);

    List<Driver> readByName(String name); // the same as findByName

    List<Driver> getByName(String name);  // the same as findByName

    List<Driver> findByAddressCity(String city);

    @Query("from Driver where name = 'M Schumacher'") // jpa query
    List<Driver> findTopDriver();

    @Query("select name from Driver where length(name) > :name_length") // jpa query
    List<String> findDriverWhereNameLengthIsGraterThan(@Param("name_length") int nameSize);
}
