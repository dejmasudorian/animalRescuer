package org.fasttrackit;

import org.fasttrackit.service.AnimalService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private AdoptingPerson owner;
    private Animal animal;
    private Vet vet;
    private AnimalService animalService;


    private Recess[] availableActivities = new Recess[10];
    private List<Animalfood> availablefood = new ArrayList<Animalfood>();


    public void start() throws Exception {
        System.out.println("Welcome to Animal Rescuer!");

        owner = initRescuer();
        System.out.println("Your name is " + owner.getName());
        System.out.println("Your adress is : " + owner.getAdress());
        System.out.println("Your level of payment for your pet is around: " + owner.getPayment());
        System.out.println("Your level of finance is around : " + owner.getFinance());
        System.out.println("The fact that you have ensurance is : " + owner.isEnsurance());
        System.out.println("The number of pet houses you have at the moment is : " + owner.getPethouse());

        System.out.println();

        animal = initAnimal();

        System.out.println();

        insertAnimalTable(animal.getName());

        System.out.println();

        initFood();

        System.out.println();

        initActivities();

        requireActivity(animal);

        System.out.println();

        requireFeeding(animal);
        //displayFood();
        //System.out.println();
        //displayActivities1();
        //System.out.println();
        //displayActivities2();
        //System.out.println();


        System.out.println("SPENDING TIME WITH YOUR PET!");
        System.out.println();
        int roundCount = getRoundCountFromUser();
        System.out.println();
        int roundsplayed = 1;
        int hungerLevel = animal.getTableHealth();
        int hapinessLevel = animal.getTableSpirit();
        System.out.println("Your pet starts the game at:" );
        System.out.println("Hunger Level: " + hungerLevel);
        System.out.println("Hapiness Level: " + hapinessLevel);
        System.out.println();
        while (roundCount!=roundsplayed )
        {
            System.out.println("ROUND " + roundsplayed + " !");
            if(hungerLevel == 10)
            {
                System.out.println("Your pet is unable to play because it's very hungry.");
                System.out.println("You should take care more of it!");
                break;
            }
            if(hapinessLevel < 3)
            {
                System.out.println("Your pet is unable to play because it's very unhappy.");
                System.out.println("You should take care more of it!");
                break;
            }
            System.out.println("It's time to play!");
            requireActivity(animal);
            System.out.println();
            System.out.println("After spending time with your pet, the stats have changed:");
            hapinessLevel++;
            hungerLevel++;
            if(hungerLevel >= 10)
                hungerLevel = 10;
            if (hapinessLevel >= 10)
                hapinessLevel = 10;
            System.out.println("HUNGER: " + hungerLevel);
            System.out.println("HAPINESS: " + hapinessLevel);
            if (hungerLevel>=6 && hungerLevel<=9){
                System.out.println("You need to feed your pet before it collapses of hunger.");
                requireFeeding(animal);
                hungerLevel -= 2;

                animal.setName(animal.getName());
                animal.setTableHealth(hungerLevel);
                animal.setTableSpirit(hapinessLevel);
                animal.setFav_food(animal.getFav_food());
                animal.recess.setName(animal.recess.getName());
                animalService.updateAnimal(animal);
            }

            roundsplayed++;

            if(roundCount == roundsplayed) {
                System.out.println("YOUR PET HAS WON THE GAME!");
                animal.setTableHealth(hungerLevel);
                animal.setTableSpirit(hapinessLevel);
            }

        }

    }

    public void insertAnimalTable(String name) throws Exception {
        List<Animal> animals = animalService.readAnimals();
        Animal animal = animals.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
        if (animal == null)
        {
            animal = createAnimalInTable();
            animalService.createAnimal(animal);
        }
        this.animal = animal;
    }

    public Animal createAnimalInTable() throws Exception {
        Animal animal = new Animal(stringForTable());
        System.out.println("Type the name of the animal: ");
        String name = stringForTable();
        animal.setName(name);

        System.out.println("Type the age of the animal:");
        int number = intForTable();
        animal.setAge(number);

        System.out.println("Type the level of health of your animal:");
        int number1 = intForTable();
        animal.setTableHealth(number1);

        System.out.println("Type the level of spirit of your animal:");
        int number2 = intForTable();
        animal.setTableSpirit(number2);

        System.out.println("Type the favorite food of the animal: ");
        String name1 = stringForTable();
        animal.setFav_food(name1);

        System.out.println("Type the name of the recess for the animal: ");
        String name2 = stringForTable();
        animal.recess.setName(name2);

        return animal;
    }

    private int getRoundCountFromUser(){
        System.out.println("Please enter the number of rounds you wish your pet should perform:");
        Scanner scanner = new Scanner(System.in);
        try {
            return  scanner.nextInt();}
        catch (InputMismatchException e) {
            System.out.println("PLease enter a valid an Integer variable:");
            return getRoundCountFromUser();
        }
    }

    private void requireFeeding(Animal animal) throws Exception {
        System.out.println("Which one of these types of food would you like to feed your pet?");
        for (int i = 0; i < availablefood.size(); i++)
            if (availablefood.get(i) != null)
            {
                System.out.println("Number "+i+ " - "+availablefood.get(i).getName());
            }
        int numberFood = chooseAnimalFoodFromUser();
        for (int i = 0; i < availablefood.size(); i++)
            if (availablefood.get(i) != null) {
                if (numberFood == i) {
                    System.out.println("You have fed your pet some " + availablefood.get(i).getName());
                    animal.setFav_food(availablefood.get(i).getName());
                }
            }
    }

    private void requireActivity(Animal animal) throws Exception {
        for(int i=0; i < availableActivities.length; i++)
            if (availableActivities[i] != null)
            {System.out.println("Number "+i+ " - "+availableActivities[i].getName());}
        int numberActivity = chooseActivityFromUser();
        for(int i=0; i < availableActivities.length; i++)
            if (availableActivities[i] != null) {
                if (numberActivity == i) {
                    System.out.println("You have practiced with your pet --> " + availableActivities[i].getName());
                    animal.recess.setName(availableActivities[i].getName());
                }
            }
    }

    private int chooseAnimalFoodFromUser() throws Exception {
        System.out.println("Please type the number in front of the food's name: ");
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextInt();
        } catch (InputMismatchException exception){
            System.out.println("You haven't any of the numbers listed. You've decided to not feed your pet.");
            return chooseAnimalFoodFromUser();
        }
    }
    private int chooseActivityFromUser() throws Exception {
        System.out.println("Please type the number in front of the activity's name: ");
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextInt();
        } catch (InputMismatchException exception){
            System.out.println("You haven't any of the numbers listed. You've decided to not play with your pet.");
            return chooseActivityFromUser();
        }
    }

    private Animal initAnimal() throws Exception {
        Animal animal = new Animal();
        int check = getTypeOfAnimalFromUser();
        if (check == 0)
        {animal = insertMammal();}
        if (check == 1)
        {animal = insertBirds();}
        return animal;
        }

    private AdoptingPerson initRescuer () throws Exception {
        AdoptingPerson rescuer = new AdoptingPerson(getOwnerFromUser(),200);
        rescuer.setAdress("Str. XYZ, Nr.12");
        rescuer.setEnsurance(true);
        rescuer.setFinance(2500);
        rescuer.setPethouse(0);
        return rescuer;
    }

    private Animal insertBirds() throws Exception {
        Animal bird = createAnimalInTable();
        return bird;

    }

    private Animal insertMammal() throws Exception {
        Animal mammal = createAnimalInTable();
        return mammal;
    }


    private int getHealthFromUser(){
        System.out.println("Please enter a number between 1 and 10 for the Heath/Hunger Level: ");
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextInt();
        } catch (InputMismatchException exception){
            System.out.println("Please enter a number next time!");
            return getHealthFromUser();
        }
    }

    private int getSpiritFromUser(){
        System.out.println("Please enter a number between 1 and 10 for the Spirit/Hapiness Level: ");
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextInt();
        } catch (InputMismatchException exception){
            System.out.println("Please enter a number next time!");
            return getSpiritFromUser();
        }
    }

    private int getTypeOfAnimalFromUser() {
        System.out.println("Choose the type of animal and write 0 or 1 bellow : mammal(0) or bird(1).");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        return index;
    }

    private String nameAnimal() throws Exception {
        System.out.println("Please enter the name of your pet: ");
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextLine();

        } catch (InputMismatchException exception){
            System.out.println("Please enter a valid string:");
            return nameAnimal();
        }
    }

    private String getOwnerFromUser() throws Exception {
        System.out.println("Please enter the name of the owner / adopting person: ");
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextLine();
        } catch (InputMismatchException exception){
            System.out.println("Please enter a valid string:");
            return getOwnerFromUser();
        }
    }

    private String getRaceOfAnimalFromUser() throws Exception {
        System.out.println("Please enter the race of your pet: ");
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextLine();
        } catch (InputMismatchException exception){
            System.out.println("Please enter a valid string:");
            return getRaceOfAnimalFromUser();
        }
    }


    private void initFood() {

        Animalfood animalfood1 = new Animalfood("Kaytee", 32,2);
        Animalfood animalfood2 = new Animalfood("Forti", 21,3);

        availablefood.add(animalfood1);
        availablefood.add(animalfood2);

    }

    private String stringForTable() throws Exception {
        Scanner scanner = new Scanner(System.in);
        try { return scanner.nextLine();

        } catch (InputMismatchException exception){
            System.out.println("Please enter a valid string:");
            return stringForTable();
        }
    }

    private int intForTable() {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        return index;
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

    public Game(){
        this.animalService = new AnimalService();
    }


}
