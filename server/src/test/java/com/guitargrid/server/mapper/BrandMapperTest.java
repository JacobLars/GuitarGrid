package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.BrandRequest;
import com.guitargrid.server.controller.dto.response.BrandListResponse;
import com.guitargrid.server.controller.dto.response.BrandResponse;
import com.guitargrid.server.model.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.guitargrid.server.utils.BrandTestData.createBrandRequest;
import static com.guitargrid.server.utils.BrandTestData.createNewBrandEntity;
import static org.junit.jupiter.api.Assertions.*;

class BrandMapperTest {
    private BrandMapper brandMapper;

    @BeforeEach
    public void setUp() {
        brandMapper = new BrandMapper();
    }

    @Test
    void shouldMapBrandRequestToBrand() {
        BrandRequest brandRequest = createBrandRequest();
        Brand brand = brandMapper.mapToBrand(brandRequest);
        assertEquals("Fender", brand.getName());
        assertEquals("fender-logo.png", brand.getLogo());
    }

    @Test
    void shouldMapBrandToBrandResponse() {
        Brand brand = createNewBrandEntity();
        BrandResponse brandResponse = brandMapper.mapToBrandResponse(brand);
        assertEquals(brand.getId(), brandResponse.id());
        assertEquals("Fender", brandResponse.name());
        assertEquals("fender-logo.png", brandResponse.logo());
    }

    @Test
    void shouldMapBrandListToBrandListResponse() {
        Brand brand = createNewBrandEntity();
        BrandListResponse brandListResponse = brandMapper.mapToBrandListResponse(List.of(brand));
        assertEquals(brand.getId(), brandListResponse.brands().get(0).id());
        assertEquals("Fender", brandListResponse.brands().get(0).name());
        assertEquals("fender-logo.png", brandListResponse.brands().get(0).logo());
    }

}