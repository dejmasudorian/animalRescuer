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
}
