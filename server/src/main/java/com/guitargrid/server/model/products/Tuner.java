package com.guitargrid.server.model.products;

import com.guitargrid.server.model.Image;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Tuner extends Product{

    private String display;
    private String design;
    private Boolean chromatic;
    private Boolean integrated_metronome;
    private Boolean integrated_microphone;
    public Tuner() {
    }

    @Builder

    public Tuner(String name, double price, int rating, int product_quantity,
                 String display, String design, Boolean chromatic,
                 Boolean integrated_metronome, Boolean integrated_microphone) {
        super(name, price, rating, product_quantity);
        this.display = display;
        this.design = design;
        this.chromatic = chromatic;
        this.integrated_metronome = integrated_metronome;
        this.integrated_microphone = integrated_microphone;
    }


}
