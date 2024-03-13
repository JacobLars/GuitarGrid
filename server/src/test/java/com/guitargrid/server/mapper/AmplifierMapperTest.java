package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.AmplifierRequest;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.model.products.Amplifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.guitargrid.server.utils.AmplifierTestData.createAmplifierEntity;
import static com.guitargrid.server.utils.AmplifierTestData.createAmplifierRequest;
import static com.guitargrid.server.utils.BrandTestData.createNewBrandEntity;
import static org.junit.jupiter.api.Assertions.*;

class AmplifierMapperTest {

    private AmplifierMapper amplifierMapper;

    @BeforeEach
    public void setUp() {
        amplifierMapper = new AmplifierMapper();
    }

    @Test
    void shouldMapAmplifierRequestToAmplifier() {
        AmplifierRequest amplifierRequest = createAmplifierRequest();
        Amplifier amplifier = amplifierMapper.mapToAmplifier(amplifierRequest);
        assertEquals(amplifierRequest.getName(), amplifier.getName());
        assertEquals(amplifierRequest.getPrice(), amplifier.getPrice());
        assertEquals(amplifierRequest.getRating(), amplifier.getRating());
        assertEquals(amplifierRequest.getProduct_quantity(), amplifier.getProduct_quantity());
    }


}