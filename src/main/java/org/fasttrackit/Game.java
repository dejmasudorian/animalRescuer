package org.fasttrackit;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private AdoptingPerson owner;
    private Animal animal;
    private Vet vet;

    private Recess[] availableActivities = new Recess[10];
    private List<Animalfood> availablefood = new ArrayList<Animalfood>();


    public void start(){
        initFood();
        System.out.println();
        initActivities();
        System.out.println();
        displayFood();
        System.out.println();
        displayActivities1();
        System.out.println();
        displayActivities2();
        System.out.println();
    }

    private void initFood() {

        Animalfood animalfood1 = new Animalfood("Kaytee", 32,2);
        Animalfood animalfood2 = new Animalfood("Forti", 21,3);

        availablefood.add(animalfood1);
        availablefood.add(animalfood2);

    }

    private void displayFood() {
        System.out.println("List of available food for animals : ");
        for (int i = 0; i < availablefood.size(); i++)
            if (availablefood.get(i) != null)
            {
                System.out.println(availablefood.get(i).getName());
            }
    }


    private void initActivities() {
        Recess activity1 = new Recess("fetching");
        Recess activity2 = new Recess("running");

        availableActivities[0] = activity1;
        availableActivities[1] = activity2;
    }

    private void displayActivities1() {
        System.out.println("Available entertaining activities for animals : ");
        for(int i=0; i < availableActivities.length; i++)
            if (availableActivities[i] != null)
            {System.out.println(availableActivities[i].getName());}

    }

    private void displayActivities2() {
        System.out.println("Enhanced for/for each Display of activities :");
        for(Recess availableActivities : availableActivities)
        {
            if (availableActivities !=null)
                System.out.println(availableActivities.getName());
        }

    }

  /**  public Game(AdoptingPerson owner, Animal animal, Vet vet) {
        this.owner = owner;
        this.animal = animal;
        this.vet = vet;
    }*/

    public AdoptingPerson getOwner() {
        return owner;
    }

    public void setOwner(AdoptingPerson owner) {
        this.owner = owner;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
