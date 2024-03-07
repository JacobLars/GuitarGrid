package com.guitargrid.server.controller.dto.request;


import com.guitargrid.server.model.Image;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class GuitarRequest extends ProductRequest {

    private String color;
    private String bodyType;
    private String neckType;
    private String fretboardType;
    private String pickups;
    private int frets;
    private int scale;
    private String type;



    public GuitarRequest(String name, double price, List<Image> images, int rating, int product_quantity,
                         String category, String color, String bodyType, String neckType, String fretboardType,
                         String pickups, int frets, int scale, String type) {
        super(name, price, images, rating, product_quantity, category);
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
