package com.guitargrid.server.model.products;

import jakarta.persistence.Entity;

@Entity
public class Picks extends Product{

    private String delivery_quantity;
    private double thickness;

    public Picks() {
    }

    public Picks(String name, int price, String category, int rating, int product_quantity,
                 String delivery_quantity, double thickness) {
        super(name, price, rating, product_quantity, category);
        this.delivery_quantity = delivery_quantity;
        this.thickness = thickness;
    }

}
