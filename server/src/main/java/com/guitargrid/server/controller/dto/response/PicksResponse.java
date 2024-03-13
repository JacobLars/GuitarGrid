package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PicksResponse extends ProductResponse {

    private String delivery_quantity;
    private double thickness;

    @Builder
    public PicksResponse(UUID id, String name, double price, List<Image> images, int rating, int product_quantity,
                         String category, String brandName, String brandLogo, String delivery_quantity,
                         double thickness) {
        super(id, name, price, images, rating, product_quantity, category, brandName, brandLogo);
        this.delivery_quantity = delivery_quantity;
        this.thickness = thickness;
    }
}
