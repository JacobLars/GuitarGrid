package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.PickupRequest;
import com.guitargrid.server.controller.dto.response.PickupResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.model.products.Pickup;
import org.springframework.stereotype.Component;

@Component
public class PickupMapper {

    public Pickup mapToPickup(PickupRequest pickupRequest) {
        return com.guitargrid.server.model.products.Pickup.builder()
                .name(pickupRequest.getName())
                .price(pickupRequest.getPrice())
                .rating(pickupRequest.getRating())
                .product_quantity(pickupRequest.getProduct_quantity())
                .wiring(pickupRequest.getWiring())
                .position(pickupRequest.getPosition())
                .active(pickupRequest.getActive())
                .output(pickupRequest.getOutput())
                .color(pickupRequest.getColor())
                .type(pickupRequest.getType())
                .category(pickupRequest.getCategory())
                .build();
    }


    public ProductResponse mapToPickupResponse(Pickup product) {
        return PickupResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .images(product.getImages())
                .rating(product.getRating())
                .product_quantity(product.getProduct_quantity())
                .category(product.getCategory())
                .brandName(product.getBrand().getName())
                .brandLogo(product.getBrand().getLogo())
                .wiring(product.getWiring())
                .position(product.getPosition())
                .active(product.getActive())
                .output(product.getOutput())
                .color(product.getColor())
                .type(product.getType())
                .build();
    }
}
