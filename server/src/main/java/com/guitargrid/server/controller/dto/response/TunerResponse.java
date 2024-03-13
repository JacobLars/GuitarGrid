package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TunerResponse extends ProductResponse {
    private String display;
    private String design;
    private Boolean chromatic;
    private Boolean integrated_metronome;
    private Boolean integrated_microphone;

    @Builder
    public TunerResponse(UUID id, String name, double price, List<Image> images, int rating,
                         int product_quantity, String category, String brandName, String brandLogo,
                         String display, String design, Boolean chromatic, Boolean integrated_metronome,
                         Boolean integrated_microphone) {
        super(id, name, price, images, rating, product_quantity, category, brandName, brandLogo);
        this.display = display;
        this.design = design;
        this.chromatic = chromatic;
        this.integrated_metronome = integrated_metronome;
        this.integrated_microphone = integrated_microphone;
    }
}
