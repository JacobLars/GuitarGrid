package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.PickupRequest;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.model.products.Pickup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.guitargrid.server.utils.BrandTestData.createNewBrandEntity;
import static com.guitargrid.server.utils.PickupTestData.*;
import static org.junit.jupiter.api.Assertions.*;

class PickupMapperTest {

    private PickupMapper pickupMapper;

    @BeforeEach
    public void setUp() {
        pickupMapper = new PickupMapper();
    }

    @Test
    void shouldMapPickupRequestToPickup() {
        PickupRequest pickupRequest = createPickupRequest();
        Pickup pickup = pickupMapper.mapToPickup(pickupRequest);
        assertEquals(pickupRequest.getName(), pickup.getName());
        assertEquals(pickupRequest.getPrice(), pickup.getPrice());
        assertEquals(pickupRequest.getRating(), pickup.getRating());
        assertEquals(pickupRequest.getProduct_quantity(), pickup.getProduct_quantity());
    }

}