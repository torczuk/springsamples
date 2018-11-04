package com.torczuk.github.domain;

import java.util.Objects;

public class Address {

    private String city;

    public Address(String city) {
        this.city = city;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
