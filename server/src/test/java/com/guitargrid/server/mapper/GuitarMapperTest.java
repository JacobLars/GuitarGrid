package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.model.products.Guitar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.guitargrid.server.utils.BrandTestData.createNewBrandEntity;
import static com.guitargrid.server.utils.GuitarTestData.createGuitarRequest;
import static org.junit.jupiter.api.Assertions.*;

class GuitarMapperTest {
    private GuitarMapper guitarMapper;

    @BeforeEach
    public void setUp() {
        guitarMapper = new GuitarMapper();
    }

    @Test
    void shouldMapGuitarRequestToGuitar() {
        GuitarRequest guitarRequest = createGuitarRequest();
        Brand brand = createNewBrandEntity();
        Guitar guitar = guitarMapper.mapToGuitar(guitarRequest);
        guitar.setBrand(brand);
        assertEquals("Stratocaster", guitar.getName());
        assertEquals("Fender", guitar.getBrand().getName());
        assertEquals(100, guitar.getPrice());
        assertEquals("electric", guitar.getType());
    }



}