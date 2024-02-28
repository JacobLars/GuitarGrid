package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;

import java.util.List;

@Builder
public record GuitarResponse(String name, double price, String type, String color, String bodyType, String neckType,
                             String fretboardType, String pickups, int frets, double scale, List<Image> images,
                             BrandResponse brand) {
}
