package com.guitargrid.server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.request.ProductRequest;
import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
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


    public Product handleRequest(String productRequest, UUID brandId){
        String productCategory;
        try {
            productCategory = objectMapper.readValue(productRequest, ProductRequest.class).getCategory();
        switch (productCategory) {
                case "guitars" -> {
                    GuitarRequest guitarRequest = objectMapper.readValue(productRequest, GuitarRequest.class);
                    return saveProduct(guitarRequest, brandId);
                }
                case "tuners" -> {
                    TunerRequest tunerRequest = objectMapper.readValue(productRequest, TunerRequest.class);
                    return saveProduct(tunerRequest, brandId);
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


    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductListResponse getQueriedProducts(String category, String type) {
       if(type != null && category.equals("guitars")){
           return productMapper.mapToProductListResponse(
                   filterGuitarsByType(type, productRepository.findByCategory(category)));
       }
       return productMapper.mapToProductListResponse(productRepository.findByCategory(category));
    }

    private List<Product> filterGuitarsByType(String type, List<Product> products) {
        return products.stream()
                .filter(product -> product instanceof Guitar)
                .filter(product -> ((Guitar) product).getType().equals(type))
                .toList();
    }

}
