package com.guitargrid.server.model;

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


    public Guitar () {
    }

    @Builder
    public Guitar(String name, double price, String brand, String type, String color) {
        super(name, price, brand);
        this.type = type;
        this.color = color;
    }



}
