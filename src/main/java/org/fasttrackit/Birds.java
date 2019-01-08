package org.fasttrackit;

public class Birds extends Animal {
    String race;
    boolean birdcage;

    public Birds(String name, String race) {
        super(name);
        this.race=race;
        System.out.println("Custom constructor invoked for the bird pets.");
    }
}
