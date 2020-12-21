package ru.x5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.UUID;

public class Student implements Serializable {

    private UUID uuid;

    private String firstName;

    private String lastName;

    public Student(String name, String lastName) {
        this.uuid = UUID.randomUUID();
        this.firstName = name;
        this.lastName = lastName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonIgnore
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
