package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.model.products.Tuner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}