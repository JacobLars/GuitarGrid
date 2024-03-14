package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.PickupRequest;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.model.products.Pickup;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.model.products.Tuner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.guitargrid.server.utils.GuitarTestData.createElectricGuitarEntity;
import static com.guitargrid.server.utils.GuitarTestData.createElectricGuitarResponse;
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


    @Mock
    private GuitarMapper guitarMapper;

    @InjectMocks
    private ProductMapper productMapper;


    @Test
    void shouldMapProductToTheCorrectType() {
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

    @Test
    void shouldMapListOfProductsToProductListResponse() {
        Tuner tuner = createTunerEntity();
        Guitar guitar = createElectricGuitarEntity();
        when(tunerMapper.mapToTunerResponse(tuner)).thenReturn(createTunerResponse());
        when(guitarMapper.mapToGuitarResponse(guitar)).thenReturn(createElectricGuitarResponse());
        ProductListResponse productListResponse = productMapper.mapToProductListResponse(List.of(tuner, guitar));
        assertEquals(productListResponse.products().size(), 2);
        assertEquals(productListResponse.products().get(0).getName(), tuner.getName());
        assertEquals(productListResponse.products().get(1).getName(), guitar.getName());

    }
}