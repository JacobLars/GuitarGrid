package com.guitargrid.server.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.request.ProductRequest;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.mapper.ProductMapper;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.model.products.Tuner;
import com.guitargrid.server.repository.BrandRepository;
import com.guitargrid.server.repository.ProductRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.guitargrid.server.utils.BrandTestData.createNewBrandEntity;
import static com.guitargrid.server.utils.GuitarTestData.*;
import static com.guitargrid.server.utils.ProductTestData.*;
import static com.guitargrid.server.utils.TunerTestData.createTunerEntity;
import static com.guitargrid.server.utils.TunerTestData.createTunerResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldReturnListOfQueriedAcousticGuitars() {
       Guitar accousticGuitar = createAcousticGuitarEntity();
       Guitar electricGuitar = createElectricGuitarEntity();
       GuitarResponse accousticGuitarResponse = createAcousticGuitarResponse();
       when(productRepository.findByCategory("guitars")).thenReturn(List.of(accousticGuitar, electricGuitar));
       when(productMapper.mapToProductListResponse(List.of(accousticGuitar)))
               .thenReturn(ProductListResponse.builder().products(List.of(accousticGuitarResponse)).build());
       ProductListResponse response = productService.getQueriedProducts("guitars", "acoustic");
       assertEquals(response.products().get(0), accousticGuitarResponse);
       assertEquals(response.products().size(), 1);
       assertEquals(response.products().get(0).getName(), accousticGuitar.getName());
    }

    @Test
    void shouldReturnListOfQueriedTuners(){
        Tuner tuner = createTunerEntity();
        TunerResponse tunerResponse = createTunerResponse();
        when(productRepository.findByCategory("tuners")).thenReturn(List.of(tuner));
        when(productMapper.mapToProductListResponse(List.of(tuner)))
                .thenReturn(ProductListResponse.builder().products(List.of(tunerResponse)).build());
        ProductListResponse response = productService.getQueriedProducts("tuners", null);
        assertEquals(response.products().get(0), tunerResponse);
        assertEquals(response.products().size(), 1);
        assertEquals(response.products().get(0).getName(), tuner.getName());
        assertInstanceOf(TunerResponse.class, response.products().get(0));
    }

    @Test
    @SneakyThrows
    void shouldReturnGuitarResponseWhenHandlingGuitarRequest(){
        String electricGuitarRequest = createProductRequestString();
        ProductRequest productRequest = createProductRequest();
        Guitar electricGuitar = createElectricGuitarEntity();
        GuitarResponse electricGuitarResponse = createElectricGuitarResponse();
        GuitarRequest guitarRequest = createGuitarRequest();
        Brand brand = createNewBrandEntity();
        ProductResponse productResponse = createProductResponse(electricGuitarResponse);
        when(objectMapper.readValue(electricGuitarRequest, ProductRequest.class)).thenReturn(productRequest);
        when(objectMapper.readValue(electricGuitarRequest, GuitarRequest.class)).thenReturn(guitarRequest);
        when(productMapper.mapRequestToProduct(guitarRequest)).thenReturn(electricGuitar);
        when(brandRepository.findById(brand.getId())).thenReturn(Optional.of(brand));
        when(productRepository.save(electricGuitar)).thenReturn(electricGuitar);
        when(productMapper.mapToProductResponse(electricGuitar)).thenReturn(productResponse);
        ProductResponse product = productService.handleRequest(electricGuitarRequest, brand.getId());
        assertEquals(product.getName(), guitarRequest.getName());
        assertEquals(product.getPrice(), guitarRequest.getPrice());
        assertEquals(product.getRating(), guitarRequest.getRating());
    }

}