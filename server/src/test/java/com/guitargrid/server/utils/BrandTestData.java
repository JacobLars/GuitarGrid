package com.guitargrid.server.utils;

import com.guitargrid.server.controller.dto.request.BrandRequest;
import com.guitargrid.server.controller.dto.response.BrandResponse;
import com.guitargrid.server.model.Brand;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class BrandTestData {

    public static final UUID BRAND_ID = UUID.randomUUID();
    public static final String BRAND_NAME = "Fender";
    public static final String BRAND_LOGO = "https://www.fender.com";
    public static final String BASE_URL_BRANDS = "/api/v1/brands";

    public static BrandRequest createBrandRequest() {
        return BrandRequest.builder()
                .name(BRAND_NAME)
                .logo(BRAND_LOGO)
                .build();
    }

    public static BrandResponse createBrandResponse() {
        return BrandResponse.builder()
                .id(BRAND_ID)
                .name(BRAND_NAME)
                .logo(BRAND_LOGO)
                .build();
    }
    public static Brand createNewBrandEntity() {
        return Brand.builder()
                .id(BRAND_ID)
                .name(BRAND_NAME)
                .logo(BRAND_LOGO)
                .build();
    }
}
