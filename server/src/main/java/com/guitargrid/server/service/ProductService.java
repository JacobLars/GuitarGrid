package com.guitargrid.server.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.controller.dto.request.GuitarRequestV2;
import com.guitargrid.server.controller.dto.request.ProductRequestV2;
import com.guitargrid.server.controller.dto.request.TunerRequestV2;
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
    ObjectMapper objectMapper = new ObjectMapper();
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product handleRequest(String productRequestV2, UUID brandId) {
        try {
            if(productRequestV2.contains("guitars")){
            GuitarRequestV2 productRequest = objectMapper.readValue(productRequestV2, GuitarRequestV2.class);
            return saveProduct(productRequest, brandId);
            } else if(productRequestV2.contains("tuners")){
                TunerRequestV2 tunerRequest = objectMapper.readValue(productRequestV2, TunerRequestV2.class);
                return saveProduct(tunerRequest, brandId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private Product saveProduct(ProductRequestV2 productRequest, UUID brandId) {
        Product product = productMapper.mapRequestToProduct(productRequest);
        productRequest.getImages().forEach(image -> image.setProduct(product));
        product.setImages(productRequest.getImages());
        product.setBrand(brandRepository.findById(brandId).orElse(null));
        return productRepository.save(product);
    }


    public Product getProductById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductListResponse getAllByCategory(String category, String type) {
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
