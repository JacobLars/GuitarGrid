package com.guitargrid.server.utils;

import com.guitargrid.server.controller.dto.request.PickupRequest;
import com.guitargrid.server.model.Image;
import com.guitargrid.server.model.products.Pickup;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class PickupTestData {

    public static final String PICKUP_NAME = "Pickup";
    public static final int PICKUP_PRICE = 100;
    public static final String PICKUP_CATEGORY = "pickup";
    public static final int PRODUCT_QUANTITY = 2;
    public static final int PICKUP_RATING = 5;
    public static final String PICKUP_WIRING = "Wiring";
    public static final String PICKUP_POSITION = "Position";
    public static final Boolean PICKUP_ACTIVE = true;
    public static final String PICKUP_OUTPUT = "Output";
    public static final String PICKUP_COLOR = "Color";
    public static final String PICKUP_TYPE = "Type";

    public static final List<Image> PICKUP_IMAGES = new ArrayList<>();

    public static PickupRequest createPickupRequest () {
        return new PickupRequest(PICKUP_NAME, PICKUP_PRICE, PICKUP_IMAGES , PICKUP_RATING,
                PRODUCT_QUANTITY, PICKUP_CATEGORY, PICKUP_WIRING, PICKUP_POSITION, PICKUP_ACTIVE,
                PICKUP_OUTPUT, PICKUP_COLOR, PICKUP_TYPE
                );
    }

    public static Pickup createPickupEntity() {
        return Pickup.builder()
                .name(PICKUP_NAME)
                .price(PICKUP_PRICE)
                .rating(PICKUP_RATING)
                .product_quantity(PRODUCT_QUANTITY)
                .wiring(PICKUP_WIRING)
                .position(PICKUP_POSITION)
                .active(PICKUP_ACTIVE)
                .output(PICKUP_OUTPUT)
                .color(PICKUP_COLOR)
                .type(PICKUP_TYPE)
                .category(PICKUP_CATEGORY)
                .build();
    }

}
