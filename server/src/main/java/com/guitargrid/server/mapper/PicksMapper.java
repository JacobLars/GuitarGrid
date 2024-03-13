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

    public PicksResponse mapToPicksResponse(Picks product) {
        return PicksResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .images(product.getImages())
                .rating(product.getRating())
                .product_quantity(product.getProduct_quantity())
                .category(product.getCategory())
                .brandName(product.getBrand().getName())
                .brandLogo(product.getBrand().getLogo())
                .delivery_quantity(product.getDelivery_quantity())
                .thickness(product.getThickness())
                .build();
    }
}
