package com.example.orderbook.domains;

public class Order {
    private int quantity;
    private double price;

    public Order(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String soString() {
        return this.price + " " + this.quantity;
    }
}
