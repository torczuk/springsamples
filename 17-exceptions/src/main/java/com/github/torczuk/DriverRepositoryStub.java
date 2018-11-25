package com.github.torczuk;

import com.github.torczuk.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class DriverRepositoryStub implements DriverRepository {

    public Driver findById(Long id) {
        if (id < 1) {
            throw new ResourceNotFoundException(String.format("Resource not found. id: %s", id));
        }
        return new Driver("stubbed", LocalDate.of(1970, 5, 1), "stubbed");
    }
}
