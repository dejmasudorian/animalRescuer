package org.fasttrackit;


import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        AdoptingPerson owner = new AdoptingPerson("Teodor",201.5);
       /** owner.name = "Teodor";1
        owner.payment = 201.5;*/

        Mammal pet1 = new Mammal("Pufu", "dog");
        pet1.age = 13;
        System.out.println(pet1.health[7]);
        pet1.fav_food = "carne de pui";

        Birds pet2 = new Birds ("Jaco", "parrot");

        Animalfood animalfood = new Animalfood("Eukanuba", 160.5, 12);
        animalfood.expiryDate = LocalDateTime.now();
        animalfood.stock = 2000;

        Recess recess = new Recess("alergatul");

        Vet vet = new Vet("Dan Mehelean");
        vet.specialty = "medium sized pets";

    }
}
