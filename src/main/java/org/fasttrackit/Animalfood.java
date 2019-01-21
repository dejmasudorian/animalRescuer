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

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
