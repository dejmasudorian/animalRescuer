package org.fasttrackit;


public class App 
{
    public static void main( String[] args )
    {
        AdoptingPerson owner = new AdoptingPerson();
        owner.name = "Teodor";
        owner.payment = 201.5;

        Animal pet = new Animal();
        pet.name = "Pufu";
        pet.age = 13;
        pet.fav_food = "carne de pui";
        Recess recess = new Recess();
        recess.name = "alergatul";

        Animalfood animalfood = new Animalfood();
        animalfood.name = "Eukanuba";
        animalfood.price = 160.5;
        animalfood.quantity = 12;
        animalfood.stock = 2000;

        Vet vet = new Vet();
        vet.name = "Dan Mehelean";
        vet.specialty = "animale de casa";
    }
}
