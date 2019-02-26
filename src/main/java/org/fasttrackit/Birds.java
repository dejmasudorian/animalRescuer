package org.fasttrackit;

public class Birds extends Animal {
    String race;
    boolean birdcage;

    public Birds() {

    }


    @Override
    public void spiritstate(int spiritindex) {
        String reaction = " is in a good mood ";
        if (race == "bird")
            reaction = " bats its wings ";
        if(spirit[spiritindex]>=8)
            System.out.println( getRace() + reaction + " at " + spirit[spiritindex]);
        else if (spirit[spiritindex]>=5 && spirit[spiritindex]<8) System.out.println(getName() + " is in a decent mood at " + spirit[spiritindex] + " level spirit, but could use improving.");
        else if (spirit[spiritindex]<5) System.out.println(getName() + "needs more of his master's attention and care more often");
    }


    public Birds(String name, String race) {
        super(name);
        this.race=race;
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
