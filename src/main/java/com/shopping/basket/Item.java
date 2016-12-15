package com.shopping.basket;

public enum Item {
    Bananas(10), Oranges(20), Apples(30), Lemons(40), Peaches(50);

    private double price;

    Item(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }



}
