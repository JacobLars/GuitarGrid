package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GuitarResponse extends ProductResponse {

    private String color;
    private String bodyType;
    private String neckType;
    private String fretboardType;
    private String pickups;
    private int frets;
    private int scale;
    private String type;

    @Builder
    public GuitarResponse(UUID id, String name, double price, List<Image> images, int rating, int product_quantity,
                          String category, String brandName, String brandLogo, String color, String bodyType,
                          String neckType, String fretboardType, String pickups, int frets, int scale, String type) {
        super(id, name, price, images, rating, product_quantity, category, brandName, brandLogo);
        this.color = color;
        this.bodyType = bodyType;
        this.neckType = neckType;
        this.fretboardType = fretboardType;
        this.pickups = pickups;
        this.frets = frets;
        this.scale = scale;
        this.type = type;
    }
}
