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
        System.out.println("Custom constuctor invoked for the Adopting Person " + name + " and his payment acquisition of : " + payment);
    }


    public void feeding(Animal animalname, Animalfood foodname){
        System.out.println(getName() + " just gave some " + foodname.getName() + " food to " + animalname.getName() + ".");
    }

    public void recesstime(Animal animalname, Recess activity)
    {
        System.out.println(getName() + " just practiced " + activity.getName() + " with " + animalname.getName() + ".");
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
