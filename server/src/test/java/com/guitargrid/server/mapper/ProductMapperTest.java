package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.PickupRequest;
import com.guitargrid.server.controller.dto.response.AmplifierResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.model.products.Pickup;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.model.products.Tuner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.guitargrid.server.utils.PickupTestData.createPickupEntity;
import static com.guitargrid.server.utils.PickupTestData.createPickupRequest;
import static com.guitargrid.server.utils.TunerTestData.createTunerEntity;
import static com.guitargrid.server.utils.TunerTestData.createTunerResponse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductMapperTest {
    
    @Mock
    private TunerMapper tunerMapper;

    @Mock
    private PickupMapper pickupMapper;

    @InjectMocks
    private ProductMapper productMapper;

    @Test
    void shouldMapListOfTypeTunerToProductListResponse() {
        Tuner amplifier = createTunerEntity();
        TunerResponse tunerResponse = createTunerResponse();
        when(tunerMapper.mapToTunerResponse(amplifier)).thenReturn(tunerResponse);
        ProductListResponse productListResponse = productMapper.mapToProductListResponse(List.of(amplifier));
        assertNotNull(productListResponse.tuners());
        assertNull(productListResponse.guitars());
        assertEquals(List.of(tunerResponse), productListResponse.tuners());
        assertInstanceOf(TunerResponse.class, productListResponse.tuners().get(0));
    }

    @Test
    void shouldMapProductToProductResponse() {
        Tuner tuner = createTunerEntity();
        TunerResponse tunerResponse = createTunerResponse();
        when(tunerMapper.mapToTunerResponse(tuner)).thenReturn(tunerResponse);
        ProductResponse productResponse = productMapper.mapToProductResponse(tuner);
        assertNotNull(productResponse.tuner());
        assertNull(productResponse.guitar());
        assertEquals(tunerResponse, productResponse.tuner());
        assertInstanceOf(TunerResponse.class, productResponse.tuner());
    }
    @Test
    void shouldMapPickupRequestToPickup() {
        PickupRequest pickupRequest = createPickupRequest();
        Pickup pickup = createPickupEntity();
        when(pickupMapper.mapToPickup(pickupRequest)).thenReturn(pickup);
        Product product = productMapper.mapRequestToProduct(pickupRequest);
        assertEquals(product.getName(), pickup.getName());
        assertEquals(product.getPrice(), pickup.getPrice());
        assertEquals(product.getRating(), pickup.getRating());
        assertEquals(product.getProduct_quantity(), pickup.getProduct_quantity());
        assertInstanceOf(Pickup.class, product);
    }

}