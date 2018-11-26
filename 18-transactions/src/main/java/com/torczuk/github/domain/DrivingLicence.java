package com.torczuk.github.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

import static javax.persistence.GenerationType.TABLE;

@Entity
public class DrivingLicence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ref;

    public DrivingLicence() {
    }

    public DrivingLicence(String ref) {
        this.ref = ref;
    }

    public Long getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    @Override
    public String toString() {
        return "DrivingLicence{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrivingLicence that = (DrivingLicence) o;
        return Objects.equals(ref, that.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref);
    }
}
