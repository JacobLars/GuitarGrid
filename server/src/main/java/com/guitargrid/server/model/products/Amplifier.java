package com.guitargrid.server.model.products;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Amplifier extends Product{

    private double weight;
    private int power;
    private int channels;
    private Boolean reverb;
    private Boolean externalFxLoop;
    private Boolean lineInput;
    private Boolean footSwitchConnection;
    private Boolean effectsProcessor;
    private Boolean microphoneInput;
    private Boolean batteryOperation;


    public Amplifier() {
    }

    @Builder
    public Amplifier(String name, double price, int rating, int product_quantity, String category,
                     double weight, int power, int channels, Boolean reverb, Boolean externalFxLoop,
                     Boolean lineInput, Boolean footSwitchConnection, Boolean effectsProcessor,
                     Boolean microphoneInput, Boolean batteryOperation) {
        super(name, price, rating, product_quantity, category);
        this.weight = weight;
        this.power = power;
        this.channels = channels;
        this.reverb = reverb;
        this.externalFxLoop = externalFxLoop;
        this.lineInput = lineInput;
        this.footSwitchConnection = footSwitchConnection;
        this.effectsProcessor = effectsProcessor;
        this.microphoneInput = microphoneInput;
        this.batteryOperation = batteryOperation;
    }

}
