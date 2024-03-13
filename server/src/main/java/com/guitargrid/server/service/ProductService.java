package com.guitargrid.server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.controller.dto.request.*;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.exception.ProductNotFoundException;
import com.guitargrid.server.mapper.ProductMapper;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.repository.BrandRepository;
import com.guitargrid.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final BrandRepository brandRepository;
    private final ObjectMapper objectMapper;

    public ProductResponse handleRequest(String productRequest, UUID brandId){
        String productCategory;
        try {
            productCategory = objectMapper.readValue(productRequest, ProductRequest.class).getCategory();
        switch (productCategory) {
                case "guitars" -> {
                    GuitarRequest guitarRequest = objectMapper.readValue(productRequest, GuitarRequest.class);
                    return productMapper.mapToProductResponse(saveProduct(guitarRequest, brandId));
                }
                case "tuners" -> {
                    TunerRequest tunerRequest = objectMapper.readValue(productRequest, TunerRequest.class);
                    return productMapper.mapToProductResponse(saveProduct(tunerRequest, brandId));
                }
                case "amplifiers" -> {
                    AmplifierRequest amplifierRequest = objectMapper.readValue(productRequest, AmplifierRequest.class);
                    return productMapper.mapToProductResponse(saveProduct(amplifierRequest, brandId));
                }
                case "pickups" -> {
                    PickupRequest pickupRequest = objectMapper.readValue(productRequest, PickupRequest.class);
                    return productMapper.mapToProductResponse(saveProduct(pickupRequest, brandId));
                }
                case "picks" -> {
                    PicksRequest picksRequest = objectMapper.readValue(productRequest, PicksRequest.class);
                    return productMapper.mapToProductResponse(saveProduct(picksRequest, brandId));
                }
                default -> throw new IllegalStateException("Unexpected value: " + productCategory);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    private Product saveProduct(ProductRequest productRequest, UUID brandId) {
        Product product = productMapper.mapRequestToProduct(productRequest);
        productRequest.getImages().forEach(image -> image.setProduct(product));
        product.setImages(productRequest.getImages());
        product.setBrand(brandRepository.findById(brandId).orElse(null));
        return productRepository.save(product);
    }


    public ProductResponse getProductById(UUID id) {
        return productMapper.mapToProductResponse(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    public ProductListResponse getQueriedProducts(String category, String type) {
       if(type != null && category.equals("guitars")){
           return productMapper.mapCategoryToProductListResponse(
                   filterGuitarsByType(type, productRepository.findByCategory(category)));
       }
       return productMapper.mapCategoryToProductListResponse(productRepository.findByCategory(category));
    }

    public ProductListResponse getProductsByBrandId(UUID brandId) {
        return productMapper.mapToProductListResponse(productRepository.findByBrandId(brandId));
    }

    private List<Product> filterGuitarsByType(String type, List<Product> products) {
        return products.stream()
                .filter(product -> product instanceof Guitar)
                .filter(product -> ((Guitar) product).getType().equals(type))
                .toList();
    }


}
