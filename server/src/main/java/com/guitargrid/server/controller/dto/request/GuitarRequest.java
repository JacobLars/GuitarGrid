package com.guitargrid.server.controller.dto.request;

import com.guitargrid.server.model.Image;
import lombok.Builder;

import java.util.List;

@Builder
public record GuitarRequest(String name, double price, List<Image> images, String type, String color,
                            String bodyType, String neckType, String fretboardType, String pickups,
                            int frets, int scale, String brandName) {
}
