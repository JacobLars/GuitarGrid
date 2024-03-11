package com.guitargrid.server.utils;

import com.guitargrid.server.controller.dto.request.ProductRequest;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.model.Image;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProductTestData {

    public static final String BASE_URL_PRODUCTS = "/api/v1/products";

    List<Image> images = List.of(new Image());
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

    public static String createProductRequestString() {
        return "{\n" +
                "  \"name\": \"Stratocaster\",\n" +
                "  \"price\": 100,\n" +
                "  \"images\": [],\n" +
                "  \"rating\": 5,\n" +
                "  \"productQuantity\": 10,\n" +
                "  \"category\": \"guitars\",\n" +
                "  \"color\": \"Sunburst\",\n" +
                "  \"bodyType\": \"Maple\",\n" +
                "  \"neckType\": \"Maple\",\n" +
                "  \"fretboardType\": \"Maple\",\n" +
                "  \"pickups\": \"Single Coil\",\n" +
                "  \"frets\": 22,\n" +
                "  \"scale\": 255,\n" +
                "  \"type\": \"electric\"\n" +
                "}";
    }

    public static ProductRequest createProductRequest(){
        return new ProductRequest(
                "Stratocaster",
                100,
                images,
                5,
                10,
                "guitars"
        );
    }

}
