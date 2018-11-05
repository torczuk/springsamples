package com.github.torczuk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Driver {

//    @JsonProperty("first_name")
    private String firstName;

//    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;

    @JsonIgnore
    private String password;

    public Driver() {
    }

    public Driver(String name, LocalDate dateOfBirth, String password) {
        this.firstName = name;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public String getIntroduce() {
        return String.format("Hi my name is %s, I was born in %s", firstName, dateOfBirth.getYear());
    }
}
