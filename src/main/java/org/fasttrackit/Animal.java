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


    public void spiritstate( int spiritindex ) {
        if(spirit[spiritindex]>=8)
                System.out.println(getName() + " is in a very good mood at " + spirit[spiritindex] + " level spirit.");
            else if (spirit[spiritindex]>=5 && spirit[spiritindex]<8) System.out.println(getName() + " is in a decent mood at " + spirit[spiritindex] + " level spirit, but could use improving.");
            else if (spirit[spiritindex]<5) System.out.println(getName() + "needs more of his master's attention and care more often");


    }

    public Animal(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getHealth() {
        return health;
    }

    public void setHealth(int[] health) {
        this.health = health;
    }

    public int[] getSpirit() {
        return spirit;
    }

    public void setSpirit(int[] spirit) {
        this.spirit = spirit;
    }

    public String getFav_food() {
        return fav_food;
    }

    public void setFav_food(String fav_food) {
        this.fav_food = fav_food;
    }

    public Recess getRecess() {
        return recess;
    }

    public void setRecess(Recess recess) {
        this.recess = recess;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    public boolean isCompatibility() {
        return compatibility;
    }

    public void setCompatibility(boolean compatibility) {
        this.compatibility = compatibility;
    }
}
