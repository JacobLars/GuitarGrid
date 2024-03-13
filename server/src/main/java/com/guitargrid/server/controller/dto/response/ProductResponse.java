package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductResponse {

    private UUID id;
    private String name;
    private double price;
    private List<Image> images;
    private int rating;
    private int product_quantity;
    private String category;
    private String brandName;
    private String brandLogo;

    public ProductResponse(UUID id, String name, double price, List<Image> images, int rating, int product_quantity,
                           String category, String brandName, String brandLogo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.images = images;
        this.rating = rating;
        this.product_quantity = product_quantity;
        this.category = category;
        this.brandName = brandName;
        this.brandLogo = brandLogo;
    }

}
