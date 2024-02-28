package com.guitargrid.server.model.products;

import com.guitargrid.server.model.Image;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Tuner extends Product{

    private String type;

    public Tuner() {
    }

    public Tuner(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
