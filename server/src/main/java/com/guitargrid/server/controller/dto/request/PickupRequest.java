package com.guitargrid.server.controller.dto.request;

import com.guitargrid.server.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PickupRequest extends ProductRequest{

    private String wiring;
    private String position;
    private Boolean active;
    private String output;
    private String color;

    public PickupRequest(String name, double price, List<Image> images, int rating, int product_quantity,
                         String category, String wiring, String position, Boolean active,
                         String output, String color) {
        super(name, price, images, rating, product_quantity, category);
        this.wiring = wiring;
        this.position = position;
        this.active = active;
        this.output = output;
        this.color = color;
    }
}
