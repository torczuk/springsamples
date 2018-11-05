package com.github.torczuk;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @RequestMapping("/{id}")
    public Driver byId(@PathVariable("id") Long id) {
        if (1L == id) {
            return new Driver("Michael", LocalDate.of(1970, 5, 1), "secret");
        } else {
            throw new IllegalArgumentException();
        }
    }
}
