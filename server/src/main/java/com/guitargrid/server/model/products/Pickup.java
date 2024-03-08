package com.guitargrid.server.model.products;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pickup extends Product{

    private String wiring;
    private String position;
    private Boolean active;
    private String output;
    private String color;
    private String type;
    public Pickup() {
    }

    @Builder
    public Pickup(String name, double price, int rating, int product_quantity,
                  String wiring, String position, Boolean active,
                  String output, String color, String type, String category) {
        super(name, price, rating, product_quantity, category);
        this.wiring = wiring;
        this.position = position;
        this.active = active;
        this.output = output;
        this.color = color;
        this.type = type;
    }

}
