package com.github.torczuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    public Driver findById(Long id) {
        return repository.findById(id);
    }

    public void deleteAll() {
        throw new RuntimeException("You do not have permission");
    }
}
