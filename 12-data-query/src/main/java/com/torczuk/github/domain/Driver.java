package com.torczuk.github.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Embedded
    private Address address;

    public Driver(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name) &&
                Objects.equals(address, driver.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
