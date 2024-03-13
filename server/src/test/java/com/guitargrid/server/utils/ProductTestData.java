package com.guitargrid.server.utils;

import com.guitargrid.server.controller.dto.request.ProductRequest;
import com.guitargrid.server.controller.dto.response.*;
import com.guitargrid.server.model.Image;
import com.guitargrid.server.model.products.Product;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProductTestData {

    public static final String BASE_URL_PRODUCTS = "/api/v1/products";

    List<Image> images = List.of(new Image());

    public static ProductResponseV2 createProductResponseV2WithGuitar(Product product) {
        return ProductResponseV2.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .rating(product.getRating())
                .product_quantity(product.getProduct_quantity())
                .category(product.getCategory())
                .images(images)
                .brandName(product.getBrand().getName())
                .brandLogo(product.getBrand().getLogo())
                .build();
    }

    public static ProductListResponseV2 createProductListResponseV2(ProductResponseV2 productResponseV2) {
        return ProductListResponseV2.builder()
                .products(List.of(productResponseV2))
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
