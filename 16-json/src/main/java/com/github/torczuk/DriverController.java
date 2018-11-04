package com.github.torczuk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

    @RequestMapping("/api/v1/driver")
    public String all() {
        return "hello I am your driver";
    }
}
