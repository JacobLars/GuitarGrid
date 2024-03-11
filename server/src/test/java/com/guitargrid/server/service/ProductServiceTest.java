package com.guitargrid.server.service;

import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.mapper.ProductMapper;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.model.products.Tuner;
import com.guitargrid.server.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.guitargrid.server.utils.GuitarTestData.*;

import static com.guitargrid.server.utils.TunerTestData.createTunerEntity;
import static com.guitargrid.server.utils.TunerTestData.createTunerResponse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldReturnListContainingAcousticGuitarsWhenQueryingProducts() {
       Guitar accousticGuitar = createAcousticGuitarEntity();
       Guitar electricGuitar = createElectricGuitarEntity();
       GuitarResponse accousticGuitarResponse = createAcousticGuitarResponse();
       when(productRepository.findByCategory("guitars")).thenReturn(List.of(accousticGuitar, electricGuitar));
       when(productMapper.mapToProductListResponse(List.of(accousticGuitar)))
               .thenReturn(ProductListResponse.builder().guitars(List.of(accousticGuitarResponse)).build());
       ProductListResponse response = productService.getQueriedProducts("guitars", "acoustic");
       assertEquals(response.guitars().get(0), accousticGuitarResponse);
       assertEquals(response.guitars().size(), 1);
       assertEquals(response.guitars().get(0).name(), accousticGuitar.getName());
    }

    @Test
    void shouldReturnListContainingTunerWhenQueryingProducts(){
        Tuner tuner = createTunerEntity();
        TunerResponse tunerResponse = createTunerResponse();
        when(productRepository.findByCategory("tuners")).thenReturn(List.of(tuner));
        when(productMapper.mapToProductListResponse(List.of(tuner)))
                .thenReturn(ProductListResponse.builder().tuners(List.of(tunerResponse)).build());
        ProductListResponse response = productService.getQueriedProducts("tuners", null);
        assertEquals(response.tuners().get(0), tunerResponse);
        assertEquals(response.tuners().size(), 1);
        assertEquals(response.tuners().get(0).name(), tuner.getName());
    }

}