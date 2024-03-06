package com.guitargrid.server.service;

import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.mapper.ProductMapper;
import com.guitargrid.server.model.products.Amplifier;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.model.products.Tuner;
import com.guitargrid.server.repository.BrandRepository;
import com.guitargrid.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository<Product> productRepository;
    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }



    public ProductListResponse getAllByCategory(String category) {
        return productMapper.mapToProductListResponse(productRepository.findByCategory(category));
    }



}
