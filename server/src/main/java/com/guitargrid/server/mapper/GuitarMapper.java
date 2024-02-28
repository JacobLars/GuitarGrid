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

    private final BrandMapper brandMapper;
    public Guitar mapToGuitar(GuitarRequest guitarRequest) {
        return Guitar.builder()
                .name(guitarRequest.name())
                .price(guitarRequest.price())
                .type(guitarRequest.type())
                .color(guitarRequest.color())
                .bodyType(guitarRequest.bodyType())
                .neckType(guitarRequest.neckType())
                .fretboardType(guitarRequest.fretboardType())
                .pickups(guitarRequest.pickups())
                .frets(guitarRequest.frets())
                .scale(guitarRequest.scale())
                .build();
    }

    public GuitarResponse mapToGuitarResponse(Guitar guitar) {
        return GuitarResponse.builder()
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
                .brand(brandMapper.mapToBrandResponse(guitar.getBrand()))
                .build();
    }

    public GuitarListResponse mapToGuitarListResponse(List<Guitar> guitars) {
        return GuitarListResponse.builder()
                .guitars(guitars.stream().map(this::mapToGuitarResponse).toList())
                .build();
    }
}
