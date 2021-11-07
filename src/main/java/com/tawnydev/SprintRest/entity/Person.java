package com.tawnydev.SprintRest.entity;

import javax.persistence.*;

@Entity
@Table(name = "person", schema = "public")
public class Person {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
