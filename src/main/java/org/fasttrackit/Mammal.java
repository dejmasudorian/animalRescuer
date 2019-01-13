package org.fasttrackit;

public class Mammal extends Animal {
    String race;
    boolean collar;


    public Mammal(String name, String race) {
        super(name);
        this.race = race;
        System.out.println("Custom constructor invoked for the mammel pets. ");
    }

    @Override
    public void spiritstate( int spiritindex) {
        String raceaction =  " is in a very good mood at ";
        if  (race == "cat")
        raceaction = " purrs ";
        if (race== "dog")
        raceaction = " fiddles tail ";
        if(spirit[spiritindex]>=8)
                System.out.println( getRace() + raceaction + "at " + spirit[spiritindex]);
            else if (spirit[spiritindex]>=5 && spirit[spiritindex]<8) System.out.println(getName() + " is in a decent mood at " + spirit[spiritindex] + " level spirit, but could use improving.");
            else if (spirit[spiritindex]<5) System.out.println(getName() + " needs more of his master's attention and care more often");
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
