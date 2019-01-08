package org.fasttrackit;

public class Animal {
    private String name;
    int age;
    int[] health = {1,2,3,4,5,6,7,8,9,10};
    int[] spirit = {1,2,3,4,5,6,7,8,9,10};
    String fav_food;
    Recess recess;

    String color;
    boolean trained;
    boolean compatibility;

    public Animal(String name) {
        this.name = name;
        System.out.println("Custom constructor invoked for the animal's name");
    }
}
