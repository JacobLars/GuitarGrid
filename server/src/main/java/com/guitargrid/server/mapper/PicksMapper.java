package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.PicksRequest;
import com.guitargrid.server.controller.dto.response.PicksResponse;
import com.guitargrid.server.model.products.Picks;
import org.springframework.stereotype.Component;

@Component
public class PicksMapper {

    public Picks mapToPicks(PicksRequest picksRequest) {
        return Picks.builder()
                .name(picksRequest.getName())
                .price(picksRequest.getPrice())
                .category(picksRequest.getCategory())
                .rating(picksRequest.getRating())
                .product_quantity(picksRequest.getProduct_quantity())
                .delivery_quantity(picksRequest.getDelivery_quantity())
                .thickness(picksRequest.getThickness())
                .build();
    }

    public PicksResponse mapToPicksResponse(Picks picks) {
        return PicksResponse.builder()
                .id(picks.getId())
                .name(picks.getName())
                .price(picks.getPrice())
                .images(picks.getImages())
                .rating(picks.getRating())
                .product_quantity(picks.getProduct_quantity())
                .category(picks.getCategory())
                .delivery_quantity(picks.getDelivery_quantity())
                .thickness(picks.getThickness())
                .brandName(picks.getBrand().getName())
                .brandLogo(picks.getBrand().getLogo())
                .build();
    }

}
