package com.guitargrid.server.controller.dto.request;

import com.guitargrid.server.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PicksRequest extends ProductRequest{

    private String delivery_quantity;
    private double thickness;

    public PicksRequest(String name, double price, List<Image> images,
                        int rating, int product_quantity, String category,
                        String delivery_quantity, double thickness) {
        super(name, price, images, rating, product_quantity, category);
        this.delivery_quantity = delivery_quantity;
        this.thickness = thickness;
    }
}
