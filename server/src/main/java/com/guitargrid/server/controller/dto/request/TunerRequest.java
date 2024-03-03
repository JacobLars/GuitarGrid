package com.guitargrid.server.controller.dto.request;

import com.guitargrid.server.model.Image;
import lombok.Builder;

import java.util.List;

@Builder
public record TunerRequest(String name, double price, List<Image> images, String display, String design,
                           Boolean chromatic, Boolean integrated_metronome, Boolean integrated_microphone,
                           int rating, int product_quantity) {
}
