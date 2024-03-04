package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record GuitarResponse(UUID id, String name, double price, String type, String color, String bodyType, String neckType,
                             String fretboardType, String pickups, int frets, double scale, List<Image> images,
                             String brandName, String brandLogo, int rating, int product_quantity, String category) {
}
