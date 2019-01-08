package org.fasttrackit;

public class Birds extends Animal {
    String race;
    boolean birdcage;


    public Birds(String name, String race) {
        super(name);
        this.race=race;
        System.out.println("Custom constructor invoked for the bird pets.");
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isBirdcage() {
        return birdcage;
    }

    public void setBirdcage(boolean birdcage) {
        this.birdcage = birdcage;
    }

}
