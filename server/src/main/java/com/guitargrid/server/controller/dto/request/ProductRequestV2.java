package com.guitargrid.server.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.guitargrid.server.model.Image;
import com.guitargrid.server.model.products.Tuner;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestV2 {

    String name;
    double price;
    List<Image> images;
    int rating;
    int product_quantity;
    String category;

    public ProductRequestV2(
            @JsonProperty("name") String name,
            @JsonProperty("price") double price,
            @JsonProperty("images") List<Image> images,
            @JsonProperty("rating") int rating,
            @JsonProperty("product_quantity") int product_quantity,
            @JsonProperty("category") String category) {
        this.name = name;
        this.price = price;
        this.images = images;
        this.rating = rating;
        this.product_quantity = product_quantity;
        this.category = category;
    }
}
