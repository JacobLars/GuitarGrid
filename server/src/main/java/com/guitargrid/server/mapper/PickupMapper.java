package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.PickupRequest;
import com.guitargrid.server.controller.dto.response.PickupResponse;
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
    public PickupResponse mapToPickupResponse(Pickup pickup) {
        return PickupResponse.builder()
                .id(pickup.getId())
                .name(pickup.getName())
                .price(pickup.getPrice())
                .rating(pickup.getRating())
                .product_quantity(pickup.getProduct_quantity())
                .images(pickup.getImages())
                .wiring(pickup.getWiring())
                .position(pickup.getPosition())
                .active(pickup.getActive())
                .output(pickup.getOutput())
                .color(pickup.getColor())
                .type(pickup.getType())
                .category(pickup.getCategory())
                .brandName(pickup.getBrand().getName())
                .brandLogo(pickup.getBrand().getLogo())
                .build();
    }



}
