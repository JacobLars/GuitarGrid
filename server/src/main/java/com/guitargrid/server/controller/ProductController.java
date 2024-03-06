package com.guitargrid.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ProductListResponse getAllProductsByCategory(@RequestParam String category,
                                                        @RequestParam(required = false) String type) {
        System.out.println(type);
        return service.getAllByCategory(category, type);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return service.getProductById(id);
    }

    @PostMapping("/{brandId}")
    public Product saveProduct(@RequestBody String product, @PathVariable UUID brandId) throws JsonProcessingException {
        return service.handleRequest(product, brandId);
    }
}
