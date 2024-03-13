package com.guitargrid.server.controller;

import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponseV2;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.exception.ProductNotFoundException;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ProductListResponse getAllProductsByCategory(@RequestParam String category,
                                                        @RequestParam(required = false) String type) {
        return service.getQueriedProducts(category, type);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable UUID id) {
        return service.getProductById(id);
    }

    @PostMapping("/{brandId}")
    @ResponseStatus(CREATED)
    public ProductResponse saveProduct(@RequestBody String productRequest, @PathVariable UUID brandId) {
        return service.handleRequest(productRequest, brandId);
    }

    @GetMapping("/brand/{brandId}")
    public ProductListResponseV2 getProductsByBrandId(@PathVariable UUID brandId) {
        return service.getProductsByBrandId(brandId);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public String handleProductNotFoundException(ProductNotFoundException e) {
        return e.getMessage();
    }

}
