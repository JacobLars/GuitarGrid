package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;

import java.util.List;

@Builder
public record TunerResponse(String name, double price,
                            String display, String design,
                            boolean chromatic, boolean integrated_metronome,
                            boolean integrated_microphone, List<Image> images,
                            String brandName, String brandLogo, double rating, int product_quantity) {
}
