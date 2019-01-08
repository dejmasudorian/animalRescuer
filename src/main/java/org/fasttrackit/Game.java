package org.fasttrackit;

public class Game {
    private AdoptingPerson owner;
    private Animal animal;
    private Vet vet;


    public Game(AdoptingPerson owner, Animal animal, Vet vet) {
        this.owner = owner;
        this.animal = animal;
        this.vet = vet;
        System.out.println("Custom constructor invoked for the Animal Rescuer Game ");
    }


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
