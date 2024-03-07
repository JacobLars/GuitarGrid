package com.guitargrid.server.controller.dto.request;


import com.guitargrid.server.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class ProductRequest {

    private String name;
    private double price;
    private List<Image> images;
    private int rating;
    private int product_quantity;
    private String category;

    public ProductRequest(String name, double price, List<Image> images, int rating, int product_quantity,
                          String category) {
        this.name = name;
        this.price = price;
        this.images = images;
        this.rating = rating;
        this.product_quantity = product_quantity;
        this.category = category;
    }
}
