package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.BrandRequest;
import com.guitargrid.server.controller.dto.response.BrandListResponse;
import com.guitargrid.server.controller.dto.response.BrandResponse;
import com.guitargrid.server.model.Brand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandMapper {

    public Brand mapToBrand(BrandRequest brandRequest) {
        return Brand.builder()
                .name(brandRequest.name())
                .logo(brandRequest.logo())
                .build();
    }

    public BrandResponse mapToBrandResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .logo(brand.getLogo())
                .build();
    }

    public BrandListResponse mapToBrandListResponse(List<Brand> brands) {
        return BrandListResponse.builder()
                .brands(brands.stream().map(this::mapToBrandResponse).toList())
                .build();
    }
}
