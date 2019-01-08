package org.fasttrackit;

public class Mammal extends Animal {
    String race;
    boolean collar;

    public Mammal(String name, String race) {
        super(name);
        this.race = race;
        System.out.println("Custom constructor invoked for the mammel pets. ");
    }
}
