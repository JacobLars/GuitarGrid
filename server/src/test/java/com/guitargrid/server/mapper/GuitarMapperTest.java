package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.response.GuitarListResponse;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.model.products.Guitar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.guitargrid.server.utils.BrandTestData.createNewBrandEntity;
import static com.guitargrid.server.utils.GuitarTestData.createElectricGuitarEntity;
import static org.junit.jupiter.api.Assertions.*;

class GuitarMapperTest {
    private GuitarMapper guitarMapper;

    @BeforeEach
    public void setUp() {
        guitarMapper = new GuitarMapper();
    }

/*    @Test
    void shouldMapGuitarRequestToGuitar() {
        GuitarRequest guitarRequest = createGuitarRequest();
        Brand brand = createNewBrandEntity();
        Guitar guitar = guitarMapper.mapToGuitar(guitarRequest);
        guitar.setBrand(brand);
        assertEquals("Stratocaster", guitar.getName());
        assertEquals("Fender", guitar.getBrand().getName());
        assertEquals(100, guitar.getPrice());
        assertEquals("electric", guitar.getType());
    }*/

    @Test
    void shouldMapGuitarToGuitarResponse() {
        Guitar guitar = createElectricGuitarEntity();
        Brand brand = createNewBrandEntity();
        guitar.setBrand(brand);
        GuitarResponse guitarResponse = guitarMapper.mapToGuitarResponse(guitar);
        assertEquals("Stratocaster", guitarResponse.name());
        assertEquals("Fender", guitarResponse.brandName());
        assertEquals(100, guitarResponse.price());
        assertEquals("electric", guitarResponse.type());
    }

    @Test
    void shouldMapGuitarListToGuitarListResponse() {
        Guitar guitar = createElectricGuitarEntity();
        Brand brand = createNewBrandEntity();
        guitar.setBrand(brand);
        GuitarListResponse guitarResponse = guitarMapper.mapToGuitarListResponse(List.of(guitar));
        assertEquals("Stratocaster", guitarResponse.guitars().get(0).name());
        assertEquals("Fender", guitarResponse.guitars().get(0).brandName());
        assertEquals(100, guitarResponse.guitars().get(0).price());
        assertEquals("electric", guitarResponse.guitars().get(0).type());
    }
}