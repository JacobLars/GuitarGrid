package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AmplifierResponse extends ProductResponse {

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

    @Builder
    public AmplifierResponse(UUID id, String name, double price, List<Image> images,
                             int rating, int product_quantity, String category, String brandName,
                             String brandLogo, double weight, int power, int channels, Boolean reverb,
                             Boolean externalFxLoop, Boolean lineInput, Boolean footSwitchConnection,
                             Boolean effectsProcessor, Boolean microphoneInput, Boolean batteryOperation) {
        super(id, name, price, images, rating, product_quantity, category, brandName, brandLogo);
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
