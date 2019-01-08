package org.fasttrackit;

import java.time.LocalDateTime;

public class Animalfood {
    private String name;
    private double price;
    private double quantity;
    double stock;
    LocalDateTime expiryDate;

    public Animalfood(String name, double price, double qunatity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

        System.out.println("Custom constructor invoked for the animal food's : name, price and quantity");
    }
}
