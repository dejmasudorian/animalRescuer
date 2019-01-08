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
}
