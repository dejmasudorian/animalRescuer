package org.fasttrackit;

public class Recess {

    private String name;


    public Recess(String name) {
        this.name = name;
        System.out.println("Custom constructor invoked for the recess activity name ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    }
