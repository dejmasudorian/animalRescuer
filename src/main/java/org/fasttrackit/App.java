package org.fasttrackit;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        AdoptingPerson owner = new AdoptingPerson("Theodor", 201.5);
        owner.setName("Theodor");
        owner.setPayment(201.5);
        owner.setAdress("XYZ Street");
        owner.setEnsurance(true);
        owner.setPethouse(1);
        owner.setFinance(2000);
        System.out.println(owner.getName());
        System.out.println(owner.getPayment());
        System.out.println(owner.getAdress());
        System.out.println(owner.isEnsurance());
        System.out.println(owner.getPethouse());
        System.out.println(owner.getFinance());

        Mammal pet1 = new Mammal("Pufu", "Dog");
        pet1.setName("Pufu");
        pet1.setRace("Dog");
        pet1.setAge(13);
        pet1.setFav_food("Meat");
        System.out.println(pet1.health[7]);
        System.out.println(pet1.getName());
        System.out.println(pet1.getRace());
        System.out.println(pet1.getAge());
        System.out.println(pet1.getFav_food());
        System.out.println(pet1.getHealth());

        Birds pet2 = new Birds ("Jaco", "parrot");

        Animalfood animalfood = new Animalfood("Eukanuba", 160.5, 12);
        animalfood.setExpiryDate(LocalDateTime.now());
        animalfood.setStock(2000);
        animalfood.setName("Ëukanuba");
        animalfood.setPrice(160.5);
        animalfood.setQuantity(12);
        System.out.println(animalfood.getName());
        System.out.println(animalfood.getPrice());
        System.out.println(animalfood.getExpiryDate());
        System.out.println(animalfood.getQuantity());



        Recess recess = new Recess("running");
        recess.setName("running");
        System.out.println(recess.getName());

        Vet vet = new Vet("Dan Mehelean");
        vet.setName("Dan Mehelean");
        vet.setSpecialty("medium sized pets");
        System.out.println(vet.getName());
        System.out.println(vet.getSpecialty());



        Animal dog = new Mammal("Rex","dog");
        Animal cat = new Mammal("Lisa", "cat");
        dog.spiritstate(9);
        cat.spiritstate(6);
        Animal bird = new Birds("Jaco","bird");
        bird.spiritstate(3);


        owner.setName("John");
        animalfood.setName("Purina");
        pet1.setName("Chaika");
        // Insert hapinessIndex and hungerIndex for position in Health Array
        owner.feeding(pet1, animalfood,7, 5);

        owner.setName("Michael");
        recess.setName("fetching");
        pet1.setName("Oslo");
        //Insert hapinessIndex for position in Spirit Array
        owner.entertain(pet1, recess,6);

        System.out.println();

        Game game = new Game();
        game.start();
    }
}
