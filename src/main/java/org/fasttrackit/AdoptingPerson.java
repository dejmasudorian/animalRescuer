package org.fasttrackit;

public class AdoptingPerson {
    private String name;
    private double payment;
/**4 Optional*/
    String adress;
    double finance;
    int pethouse;
    boolean ensurance;


    public AdoptingPerson(String name, double payment){
        this.name = name;
        this.payment = payment;
    }


    public void feeding(Animal animalname, Animalfood foodname, int happinessIndex, int hungerIndex){
        System.out.println("FEEDING:");
        System.out.println(getName() + " just gave some " + foodname.getName() + " food to " + animalname.getName() + ".");
        int hungerLevel = animalname.health[hungerIndex];

        hungerLevel--;
        System.out.println("Hunger level has downgraded from " + animalname.health[hungerIndex] + "to" + hungerLevel);

        String favoriteFoodName = " Purina ";
        int happinessLevel = animalname.spirit[happinessIndex];
        if (foodname.getName() == favoriteFoodName)
            happinessLevel++;
        System.out.println("After feeding " + animalname.getName() + " with " + favoriteFoodName + " , its happiness level improved to " + happinessLevel);

    }

    public void entertain(Animal animalname, Recess activity, int happinessIndex)
    {
        System.out.println("ETERTAIN:");
        System.out.println(getName() + " just practiced " + activity.getName() + " with " + animalname.getName() + ".");
        int happinessLevel = animalname.spirit[happinessIndex];

        happinessLevel--;
        System.out.println("Happiness level has downgraded from " + animalname.health[happinessIndex] + "to" + happinessLevel);

        String favoriteActivityName = "running";
        happinessLevel = animalname.spirit[happinessIndex];
        if ( favoriteActivityName == activity.getName())
            happinessLevel += 2;
        else happinessLevel++;

        System.out.println("After doing " + activity.getName() + " with " + animalname.getName() + " , its happiness level improved to " + happinessLevel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getFinance() {
        return finance;
    }

    public void setFinance(double finance) {
        this.finance = finance;
    }

    public int getPethouse() {
        return pethouse;
    }

    public void setPethouse(int pethouse) {
        this.pethouse = pethouse;
    }

    public boolean isEnsurance() {
        return ensurance;
    }

    public void setEnsurance(boolean ensurance) {
        this.ensurance = ensurance;
    }
}
