package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.response.GuitarListResponse;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.model.products.Guitar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GuitarMapper {

    public Guitar mapToGuitar(GuitarRequest guitarRequest) {
        return Guitar.builder()
                .name(guitarRequest.getName())
                .price(guitarRequest.getPrice())
                .type(guitarRequest.getType())
                .color(guitarRequest.getColor())
                .bodyType(guitarRequest.getBodyType())
                .neckType(guitarRequest.getNeckType())
                .fretboardType(guitarRequest.getFretboardType())
                .pickups(guitarRequest.getPickups())
                .frets(guitarRequest.getFrets())
                .scale(guitarRequest.getScale())
                .rating(guitarRequest.getRating())
                .product_quantity(guitarRequest.getProduct_quantity())
                .category(guitarRequest.getCategory())
                .build();
    }

    public GuitarResponse mapToGuitarResponse(Guitar guitar) {
        return GuitarResponse.builder()
                .id(guitar.getId())
                .name(guitar.getName())
                .price(guitar.getPrice())
                .type(guitar.getType())
                .color(guitar.getColor())
                .bodyType(guitar.getBodyType())
                .neckType(guitar.getNeckType())
                .fretboardType(guitar.getFretboardType())
                .pickups(guitar.getPickups())
                .frets(guitar.getFrets())
                .scale(guitar.getScale())
                .images(guitar.getImages())
                .brandName(guitar.getBrand().getName())
                .brandLogo(guitar.getBrand().getLogo())
                .rating(guitar.getRating())
                .product_quantity(guitar.getProduct_quantity())
                .category(guitar.getCategory())
                .build();
    }

    public GuitarListResponse mapToGuitarListResponse(List<Guitar> guitars) {
        return GuitarListResponse.builder()
                .guitars(guitars.stream().map(this::mapToGuitarResponse).toList())
                .build();
    }
}
