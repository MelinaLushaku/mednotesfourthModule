package com.example.mednotes4.Model;

import javax.persistence.Embeddable;

@Embeddable
public class PatientEntity {
    private String name;
    private String surname;
    private int personalNumber;

    public PatientEntity() {
    }

    public PatientEntity(String name, String surname , int personalNumber) {
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }
}
