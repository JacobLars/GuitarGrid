package com.guitargrid.server.controller;

import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> getAllProductsByCategory(@RequestParam String category) {
        return service.getAllByCategory(category);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return service.getProductById(id);
    }

    @PostMapping("/{brandId}")
    public Product saveProduct(@RequestBody Product product, @PathVariable UUID brandId) {
        return service.saveProduct(product, brandId);
    }



}
