package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.AmplifierRequest;
import com.guitargrid.server.controller.dto.response.AmplifierResponse;
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

    @Test
    void shouldMapAmplifierToAmplifierResponse(){
        Amplifier amplifier = createAmplifierEntity();
        Brand brand = createNewBrandEntity();
        amplifier.setBrand(brand);
        AmplifierResponse amplifierResponse = amplifierMapper.mapToAmplifierResponse(amplifier);
        assertEquals(amplifier.getId(), amplifierResponse.id());
        assertEquals(amplifier.getName(), amplifierResponse.name());
        assertEquals(amplifier.getPrice(), amplifierResponse.price());
        assertEquals(amplifier.getRating(), amplifierResponse.rating());
        assertEquals(amplifier.getProduct_quantity(), amplifierResponse.product_quantity());
        assertEquals(amplifier.getCategory(), amplifierResponse.category());
        assertEquals(amplifier.getImages(), amplifierResponse.images());
        assertEquals(amplifier.getBrand().getName(), amplifierResponse.brandName());
        assertEquals(amplifier.getBrand().getLogo(), amplifierResponse.brandLogo());
        assertEquals(amplifier.getWeight(), amplifierResponse.weight());
    }

}