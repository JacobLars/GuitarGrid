package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.model.products.Tuner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.guitargrid.server.utils.BrandTestData.createNewBrandEntity;
import static com.guitargrid.server.utils.TunerTestData.createTunerEntity;
import static com.guitargrid.server.utils.TunerTestData.createTunerRequest;
import static org.junit.jupiter.api.Assertions.*;

class TunerMapperTest {

    private TunerMapper tunerMapper;

    @BeforeEach
    public void setUp() {
        tunerMapper = new TunerMapper();
    }

    @Test
    void shouldMapTunerRequestToTuner() {
        TunerRequest tunerRequest = createTunerRequest();
        Tuner tuner = tunerMapper.mapToTuner(tunerRequest);
        assertEquals("Tuner", tuner.getName());
        assertEquals(100, tuner.getPrice());
        assertInstanceOf(Tuner.class, tuner);
    }

    @Test
    void shouldMapTunerToTunerResponse() {
        Tuner tuner = createTunerEntity();
        Brand brand = createNewBrandEntity();
        tuner.setBrand(brand);
        TunerResponse tunerResponse = tunerMapper.mapToTunerResponse(tuner);
        assertEquals("Tuner", tunerResponse.name());
        assertEquals(100, tunerResponse.price());
        assertInstanceOf(TunerResponse.class, tunerResponse);
    }

}