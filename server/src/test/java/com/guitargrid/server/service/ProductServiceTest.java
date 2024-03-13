package com.guitargrid.server.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.mapper.ProductMapper;
import com.guitargrid.server.repository.BrandRepository;
import com.guitargrid.server.repository.ProductRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.guitargrid.server.utils.TunerTestData.createTunerResponse;

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

/*    @Test
    void shouldReturnListContainingAcousticGuitarsWhenQueryingProducts() {
       Guitar accousticGuitar = createAcousticGuitarEntity();
       Guitar electricGuitar = createElectricGuitarEntity();
       GuitarResponse accousticGuitarResponse = createAcousticGuitarResponse();
       when(productRepository.findByCategory("guitars")).thenReturn(List.of(accousticGuitar, electricGuitar));
       when(productMapper.mapCategoryToProductListResponse(List.of(accousticGuitar)))
               .thenReturn(ProductListResponse.builder().guitars(List.of(accousticGuitarResponse)).build());
       ProductListResponse response = productService.getQueriedProducts("guitars", "acoustic");
       assertEquals(response.guitars().get(0), accousticGuitarResponse);
       assertEquals(response.guitars().size(), 1);
       assertEquals(response.guitars().get(0).name(), accousticGuitar.getName());
         assertInstanceOf(GuitarResponse.class, response.guitars().get(0));
    }

    @Test
    void shouldReturnListContainingTunersWhenQueryingProducts(){
        Tuner tuner = createTunerEntity();
        TunerResponse tunerResponse = createTunerResponse();
        when(productRepository.findByCategory("tuners")).thenReturn(List.of(tuner));
        when(productMapper.mapCategoryToProductListResponse(List.of(tuner)))
                .thenReturn(ProductListResponse.builder().tuners(List.of(tunerResponse)).build());
        ProductListResponse response = productService.getQueriedProducts("tuners", null);
        assertEquals(response.tuners().get(0), tunerResponse);
        assertEquals(response.tuners().size(), 1);
        assertEquals(response.tuners().get(0).name(), tuner.getName());
        assertInstanceOf(TunerResponse.class, response.tuners().get(0));
    }*/

/*
    @Test
    @SneakyThrows
    void shouldReturnGuitarResponseWhenHandlingGuitarRequest(){
        String electricGuitarRequest = createProductRequestString();
        ProductRequest productRequest = createProductRequest();
        Guitar electricGuitar = createElectricGuitarEntity();
        GuitarResponse electricGuitarResponse = createElectricGuitarResponse();
        GuitarRequest guitarRequest = createGuitarRequest();
        Brand brand = createNewBrandEntity();
        ProductResponse productResponse = ProductResponse.builder().guitar(electricGuitarResponse).build();
        when(objectMapper.readValue(electricGuitarRequest, ProductRequest.class)).thenReturn(productRequest);
        when(objectMapper.readValue(electricGuitarRequest, GuitarRequest.class)).thenReturn(guitarRequest);
        when(productMapper.mapRequestToProduct(guitarRequest)).thenReturn(electricGuitar);
        when(brandRepository.findById(brand.getId())).thenReturn(Optional.of(brand));
        when(productRepository.save(electricGuitar)).thenReturn(electricGuitar);
        when(productMapper.mapToProductResponse(electricGuitar)).thenReturn(productResponse);
        ProductResponse product = productService.handleRequest(electricGuitarRequest, brand.getId());
        assertEquals(product.guitar().name(), guitarRequest.getName());
        assertInstanceOf(GuitarResponse.class, product.guitar());
    }
*/

}