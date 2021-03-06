package com.github.torczuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable("id") Long id) {
        Driver driver = driverService.findById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("ETag", String.format("Etag: %s", driver.hashCode()));

        return new ResponseEntity<>(driver, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Driver> getDriverById() {
        driverService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
