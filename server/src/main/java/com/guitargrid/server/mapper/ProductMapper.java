package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.request.ProductRequest;
import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.model.products.Tuner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductMapper {

    private final GuitarMapper guitarMapper;
    private final TunerMapper tunerMapper;

    public ProductListResponse mapToProductListResponse(List<Product> products) {
        if (products.get(0) instanceof Guitar) {
            List<Guitar> guitars = filterProductsByType(products, Guitar.class);
            return buildProductListResponseWithGuitars(guitars);
        } else if (products.get(0) instanceof Tuner) {
            List<Tuner> tuners = filterProductsByType(products, Tuner.class);
            return buildProductListResponseWithTuners(tuners);
        }
        return new ProductListResponse(null, null);
    }

    public Product mapRequestToProduct(ProductRequest product) {
           if (product instanceof GuitarRequest) {
                return guitarMapper.mapToGuitar((GuitarRequest) product);
            } else if (product instanceof TunerRequest) {
                return tunerMapper.mapToTuner((TunerRequest) product);
            }
            return null;
    }

    public ProductResponse mapToProductResponse(Product product) {
        if (product instanceof Guitar) {
            return ProductResponse.builder()
                    .guitar(guitarMapper.mapToGuitarResponse((Guitar) product))
                    .build();
        } else if (product instanceof Tuner) {
            return ProductResponse.builder()
                    .tuner(tunerMapper.mapToTunerResponse((Tuner) product))
                    .build();
        }
        return null;
    }

    private <T extends Product> List<T> filterProductsByType(List<Product> products, Class<T> type) {
        return products.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .toList();
    }

    private ProductListResponse buildProductListResponseWithGuitars(List<Guitar> guitars) {
        return ProductListResponse.builder()
                .guitars(guitars.stream().map(guitarMapper::mapToGuitarResponse).toList())
                .build();
    }

    private ProductListResponse buildProductListResponseWithTuners(List<Tuner> tuners) {
        return ProductListResponse.builder()
                .tuners(tuners.stream().map(tunerMapper::mapToTunerResponse).toList())
                .build();
    }
}
