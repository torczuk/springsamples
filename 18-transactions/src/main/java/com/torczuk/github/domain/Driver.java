package com.torczuk.github.domain;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.TABLE;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private DrivingLicence drivingLicence;

    public Driver(String name) {
        this.name = name;
    }

    public Driver(String name, DrivingLicence drivingLicence) {
        this.name = name;
        this.drivingLicence = drivingLicence;
    }

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DrivingLicence getDrivingLicence() {
        return drivingLicence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
