package com.guitargrid.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ProductListResponse getAllProductsByCategory(@RequestParam String category,
                                                        @RequestParam(required = false) String type) {
        return service.getAllByCategory(category, type);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return service.getProductById(id);
    }

    @PostMapping("/{brandId}")
    @ResponseStatus(CREATED)
    public Product saveProduct(@RequestBody String productRequest, @PathVariable UUID brandId) {
        return service.handleRequest(productRequest, brandId);
    }
}
