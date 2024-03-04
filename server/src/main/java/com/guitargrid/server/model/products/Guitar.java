package com.guitargrid.server.model.products;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Guitar extends Product{

    private String type;
    private String color;
    private String bodyType;
    private String neckType;
    private String fretboardType;
    private String pickups;
    private int frets;
    private int scale;

    public Guitar () {
    }

    @Builder
    public Guitar(String name, double price, String type, String color,
                  String bodyType, String neckType, String fretboardType, String pickups,
                  int frets, int scale, int rating, int product_quantity, String category) {
        super(name, price, rating, product_quantity, category);
        this.type = type;
        this.color = color;
        this.bodyType = bodyType;
        this.neckType = neckType;
        this.fretboardType = fretboardType;
        this.pickups = pickups;
        this.frets = frets;
        this.scale = scale;
    }
}
