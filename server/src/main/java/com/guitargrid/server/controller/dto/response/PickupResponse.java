package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PickupResponse extends ProductResponse {
    private String wiring;
    private String position;
    private Boolean active;
    private String output;
    private String color;
    private String type;

    @Builder
    public PickupResponse(UUID id, String name, double price, List<Image> images, int rating,
                          int product_quantity, String category, String brandName, String brandLogo,
                          String wiring, String position, Boolean active, String output, String color, String type) {
        super(id, name, price, images, rating, product_quantity, category, brandName, brandLogo);
        this.wiring = wiring;
        this.position = position;
        this.active = active;
        this.output = output;
        this.color = color;
        this.type = type;
    }
}
