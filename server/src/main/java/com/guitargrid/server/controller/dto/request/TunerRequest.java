package com.guitargrid.server.controller.dto.request;


import com.guitargrid.server.model.Image;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class TunerRequest extends ProductRequest {

    private String display;
    private String design;
    private Boolean chromatic;
    private Boolean integrated_metronome;
    private Boolean integrated_microphone;

    public TunerRequest(String name, double price, List<Image> images, int rating, int product_quantity,
                        String category, String display, String design, Boolean chromatic,
                        Boolean integrated_metronome, Boolean integrated_microphone) {
        super(name, price, images, rating, product_quantity, category);
        this.display = display;
        this.design = design;
        this.chromatic = chromatic;
        this.integrated_metronome = integrated_metronome;
        this.integrated_microphone = integrated_microphone;
    }
}
