package org.fasttrackit;

public class Vet {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    private String name;
    String specialty;

    public Vet(String name) {
        this.name = name;
        System.out.println("Custom constructor invoked for the veterinar's name");
    }
}
