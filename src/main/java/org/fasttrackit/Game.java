package org.fasttrackit;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private AdoptingPerson owner;
    private Animal animal;
    private Vet vet;

    private Recess[] availableActivities = new Recess[10];
    private List<Animalfood> availablefood = new ArrayList<Animalfood>();


    public void start() throws Exception {
        System.out.println("Welcome to Animal Rescuer!");
        initRescuer();
        System.out.println();
        int indexHealth = getHealthFromUser();
        int indexSpirit = getSpiritFromUser();
        initAnimal(indexHealth, indexSpirit);
        System.out.println();
        initFood();
        System.out.println();
        initActivities();
        requireActivity();
        System.out.println();
        requireFeeding();
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
        int hungerLevel = indexHealth;
        int hapinessLevel = indexSpirit;
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
            requireActivity();
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
                requireFeeding();
                hungerLevel -= 2;}

            roundsplayed++;

            if(roundCount == roundsplayed)
                System.out.println("YOUR PET HAS WON THE GAME!");

        }

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

    private void requireFeeding() throws Exception {
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
                }
            }
    }

    private void requireActivity() throws Exception {
        for(int i=0; i < availableActivities.length; i++)
            if (availableActivities[i] != null)
            {System.out.println("Number "+i+ " - "+availableActivities[i].getName());}
        int numberActivity = chooseActivityFromUser();
        for(int i=0; i < availableActivities.length; i++)
            if (availableActivities[i] != null) {
                if (numberActivity == i) {
                    System.out.println("You have practiced with your pet --> " + availableActivities[i].getName());
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

    private void initAnimal(int indexHealth, int indexSpirit) throws Exception {
        int check = getTypeOfAnimalFromUser();
        if (check == 0)
        {insertMammal(indexHealth, indexSpirit);}
        if (check == 1)
        {insertBirds(indexHealth,indexSpirit);}
        }

    private void initRescuer () throws Exception {
        AdoptingPerson rescuer = new AdoptingPerson(getOwnerFromUser(),200);
        rescuer.setAdress("Str. XYZ, Nr.12");
        rescuer.setEnsurance(true);
        rescuer.setFinance(2500);
        rescuer.setPethouse(0);
        System.out.println("Your name is " + rescuer.getName());
        System.out.println("Your adress is : " + rescuer.getAdress());
        System.out.println("Your level of payment for your pet is around: " + rescuer.getPayment());
        System.out.println("Your level of finance is around : " + rescuer.getFinance());
        System.out.println("The fact that you have ensurance is : " + rescuer.isEnsurance());
        System.out.println("The number of pet houses you have at the moment is : " + rescuer.getPethouse());
    }

    private  void insertBirds(int indexHealth, int indexSpirit) throws Exception {
        Animal bird = new Birds(nameAnimal(),getRaceOfAnimalFromUser());
        bird.setAge(3);
        bird.setFav_food("seeds");
        ((Birds) bird).setBirdcage(true);
        System.out.println("Your pet bird's name is: " + bird.getName());
        System.out.println("Its race is: " + ((Birds) bird).getRace());
        System.out.println("Its health condition is: " + bird.health[indexHealth-1]);
        System.out.println("Its spirit condition is: " + bird.spirit[indexSpirit-1]);
        System.out.println("Its age is: " + bird.getAge());
        System.out.println("Its favorite food is : " + bird.getFav_food());

    }

    private void insertMammal(int indexHealth, int indexSpirit) throws Exception {
        Animal animal = new Mammal(nameAnimal(),getRaceOfAnimalFromUser());
        animal.setAge(4);
        animal.setFav_food("Meat");
        ((Mammal) animal).setCollar(true);
        System.out.println("Your animal mammal's name is: " + animal.getName());
        System.out.println("Its race is: " + ((Mammal) animal).getRace());
        System.out.println("Its age is: " + animal.getAge());
        System.out.println("Its favorite food is : " + animal.getFav_food());
        System.out.println("Its health condition is: " + animal.health[indexHealth-1]);
        System.out.println("Its spirit condition is: " + animal.spirit[indexSpirit-1]);
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
