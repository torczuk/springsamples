package com.github.torczuk;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DriverServiceStub implements DriverService {
    public Driver findById(Long id) {
        return Long.valueOf(1).equals(id) ? new Driver("Michael", LocalDate.of(1970, 5, 1), "secret") : null;
    }
}
