package org.fasttrackit;

public class Mammal extends Animal {
    String race;
    boolean collar;


    public Mammal(String name, String race) {
        super(name);
        this.race = race;
        System.out.println("Custom constructor invoked for the mammel pets. ");
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isCollar() {
        return collar;
    }

    public void setCollar(boolean collar) {
        this.collar = collar;
    }
}
