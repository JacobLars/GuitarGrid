package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.*;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
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

    public ProductListResponse mapToProductListResponse(List<Product> products) {
        if (products.get(0) instanceof Guitar) {
            List<Guitar> guitars = filterProductsByType(products, Guitar.class);
            return buildProductListResponseWithGuitars(guitars);
        } else if (products.get(0) instanceof Tuner) {
            List<Tuner> tuners = filterProductsByType(products, Tuner.class);
            return buildProductListResponseWithTuners(tuners);
        }else if(products.get(0) instanceof Amplifier){
            return buildProductListResponseWithAmplifiers(filterProductsByType(products, Amplifier.class));
        }else if(products.get(0) instanceof Pickup){
            return buildProductListResponseWithPickups(filterProductsByType(products, Pickup.class));
        }
        return new ProductListResponse(null, null, null, null);
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
        }else if (product instanceof Amplifier) {
            return ProductResponse.builder()
                    .amplifier(amplifierMapper.mapToAmplifierResponse((Amplifier) product))
                    .build();
        }else if (product instanceof Pickup){
            return ProductResponse.builder()
                    .pickup(pickupMapper.mapToPickupResponse((Pickup) product))
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

    private ProductListResponse buildProductListResponseWithAmplifiers(List<Amplifier> amplifiers) {
        return ProductListResponse.builder()
                .amplifiers(amplifiers.stream().map(amplifierMapper::mapToAmplifierResponse).toList())
                .build();
    }


    private ProductListResponse buildProductListResponseWithPickups(List<Pickup> pickups) {
        return ProductListResponse.builder()
                .pickups(pickups.stream().map(pickupMapper::mapToPickupResponse).toList())
                .build();
    }

}
