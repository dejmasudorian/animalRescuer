package org.fasttrackit;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Animal {
    private long id;
    private String name;
    int age;
    int[] health = {1,2,3,4,5,6,7,8,9,10};
    int[] spirit = {1,2,3,4,5,6,7,8,9,10};
    int tableHealth;

    public int getTableHealth() {
        return health[tableHealth-1];
    }

    public void setTableHealth(int tableHealth) {
        this.tableHealth = health[tableHealth-1];
    }

    public int getTableSpirit() {
        return health[tableSpirit-1];
    }

    public void setTableSpirit(int tableSpirit) {
        this.tableSpirit = health[tableSpirit-1];
    }

    int tableSpirit;
    String fav_food;
    Recess recess;


    public void spiritstate(int spiritindex ) {
        if(spirit[spiritindex]>=8)
            System.out.println(getName() + " is in a very good mood at " + spirit[spiritindex] + " level spirit.");
        else if (spirit[spiritindex]>=5 && spirit[spiritindex]<8) System.out.println(getName() + " is in a decent mood at " + spirit[spiritindex] + " level spirit, but could use improving.");
        else if (spirit[spiritindex]<5) System.out.println(getName() + "needs more of his master's attention and care more often");


    }

    private int healthFromUser(){
        System.out.println("Please enter a number between 1 and 10 for the Heath: ");
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextInt();
        } catch (InputMismatchException exception){
            System.out.println("Please enter a number next time!");
            return healthFromUser();
        }
    }

    private int spiritFromUser(){
        System.out.println("Please enter a number between 1 and 10 for the Spirit Level: ");
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextInt();
        } catch (InputMismatchException exception){
            System.out.println("Please enter a number next time!");
            return spiritFromUser();
        }
    }


    public int getHealth() {
        int i;
        int j = healthFromUser();
        return health[j-1];
    }

    public void setHealth(int[] health) {
        this.health = health;
    }

    public int getSpirit() {
            int i;
            int j = spiritFromUser();
            return spirit[j-1];
        }

    public void setSpirit(int[] spirit) {
        this.spirit = spirit;
    }

    public Animal(String name) {
        this.name=name;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Animal() {
    }


    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", health=" + Arrays.toString(health) +
                ", spirit=" + Arrays.toString(spirit) +
                ", fav_food='" + fav_food + '\'' +
                ", recess=" + recess +
                '}';
    }
}
