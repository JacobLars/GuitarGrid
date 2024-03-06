package com.guitargrid.server.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guitargrid.server.model.Image;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuitarRequestV2 extends ProductRequestV2{

    private String color;
    private String bodyType;
    private String neckType;
    private String fretboardType;
    private String pickups;
    private int frets;
    private int scale;
    private String type;



    public GuitarRequestV2(@JsonProperty("name") String name,
                           @JsonProperty("price") double price,
                           @JsonProperty("images") List<Image> images,
                           @JsonProperty("rating")int rating,
                           @JsonProperty("product_quantity")int product_quantity,
                           @JsonProperty("category") String category,
                           @JsonProperty("color")String color,
                           @JsonProperty("bodyType")String bodyType,
                           @JsonProperty("neckType")String neckType,
                           @JsonProperty("fretboardType")String fretboardType,
                           @JsonProperty("pickups")String pickups,
                           @JsonProperty("frets")int frets,
                           @JsonProperty("scale")int scale,
                           @JsonProperty("type")String type) {
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
