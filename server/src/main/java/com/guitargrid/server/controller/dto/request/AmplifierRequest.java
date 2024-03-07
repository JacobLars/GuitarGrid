package com.guitargrid.server.controller.dto.request;

import com.guitargrid.server.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AmplifierRequest extends ProductRequest{

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

    public AmplifierRequest(String name, double price, List<Image> images, int rating,
                            int product_quantity, String category, double weight, int power,
                            int channels, Boolean reverb, Boolean externalFxLoop, Boolean lineInput,
                            Boolean footSwitchConnection, Boolean effectsProcessor,
                            Boolean microphoneInput, Boolean batteryOperation) {
        super(name, price, images, rating, product_quantity, category);
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
