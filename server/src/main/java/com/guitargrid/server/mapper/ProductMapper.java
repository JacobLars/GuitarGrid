package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.*;
import com.guitargrid.server.controller.dto.response.*;
import com.guitargrid.server.model.products.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductMapper {

    private final GuitarMapper guitarMapper;
    private final TunerMapper tunerMapper;
    private final AmplifierMapper amplifierMapper;
    private final PickupMapper pickupMapper;
    private final PicksMapper picksMapper;

    public ProductListResponse mapCategoryToProductListResponse(List<Product> products) {
        return ProductListResponse.builder()
                .products(products.stream().map(this::mapToProductResponse).toList())
                .build();
    }

    public ProductListResponse mapToProductListResponse(List<Product> products){
        return ProductListResponse.builder()
                .products(products.stream().map(this::mapToProductResponse).toList())
                .build();
    }

    public ProductResponse mapToProductResponse(Product product){
        switch (product.getCategory()) {
            case "amplifiers" -> {return  amplifierMapper.mapToAmplifierResponse((Amplifier) product);}
            case "guitars" -> {return guitarMapper.mapToGuitarResponse((Guitar) product);}
            case "tuners" -> {return tunerMapper.mapToTunerResponse((Tuner) product);}
            case "pickups" -> {return pickupMapper.mapToPickupResponse((Pickup) product);}
            case "picks" -> {return picksMapper.mapToPicksResponse((Picks) product);}
        }
        return null;
    }

    public Product mapRequestToProduct(ProductRequest product) {
           if (product instanceof GuitarRequest) {
                return guitarMapper.mapToGuitar((GuitarRequest) product);
            } else if (product instanceof TunerRequest) {
                return tunerMapper.mapToTuner((TunerRequest) product);
            }else if (product instanceof AmplifierRequest) {
                return amplifierMapper.mapToAmplifier((AmplifierRequest) product);
            }else if(product instanceof PickupRequest){
                return pickupMapper.mapToPickup((PickupRequest) product);
            }else if (product instanceof PicksRequest){
                return picksMapper.mapToPicks((PicksRequest) product);
            }
            return null;
    }


}
