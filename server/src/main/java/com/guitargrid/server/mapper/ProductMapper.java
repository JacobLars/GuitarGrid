package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.*;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponseV2;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.controller.dto.response.ProductResponseV2;
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


    public ProductListResponseV2 mapCategoryToProductListResponseV2(List<Product> products) {
        return ProductListResponseV2.builder()
                .products(products.stream().map(this::mapToProductResponseV2).toList())
                .build();
    }

    public ProductListResponseV2 mapToProductListResponse(List<Product> products){
        return ProductListResponseV2.builder()
                .products(products.stream().map(this::mapToProductResponseV2).toList())
                .build();
    }

    public ProductResponseV2 mapToProductResponseV2(Product product){
        return ProductResponseV2.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .rating(product.getRating())
                .product_quantity(product.getProduct_quantity())
                .category(product.getCategory())
                .images(product.getImages())
                .brandName(product.getBrand().getName())
                .brandLogo(product.getBrand().getLogo())
                .build();
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
        }else if (product instanceof Picks){
            return ProductResponse.builder()
                    .picks(picksMapper.mapToPicksResponse((Picks) product))
                    .build();
        }
        return null;
    }

}
