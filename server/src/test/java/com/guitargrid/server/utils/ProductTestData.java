package com.guitargrid.server.utils;

import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.model.products.Product;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProductTestData {

    public static final String BASE_URL_PRODUCTS = "/api/v1/products";

    public static ProductListResponse createProductListResponseWithTuners(TunerResponse tunerResponse) {
        return ProductListResponse.builder()
                .tuners(List.of(tunerResponse))
                .build();
    }

    public static ProductResponse createProductResponseWithGuitar(GuitarResponse guitar) {
        return ProductResponse.builder()
                .guitar(guitar)
                .build();
    }

    public static ProductListResponse createProductListResponseWithGuitars(GuitarResponse guitarResponse) {
        return ProductListResponse.builder()
                .guitars(List.of(guitarResponse))
                .build();
    }

}
