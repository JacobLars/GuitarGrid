package com.guitargrid.server.service;

import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.mapper.ProductMapper;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.guitargrid.server.utils.GuitarTestData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository<Product> productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void testGetAllProductsByCategory() {
        List<Product> mockProducts = new ArrayList<>();
        Guitar mockGuitar = createElectricGuitarEntity();
        Guitar mockGuitar2 = createAcousticGuitarEntity();
        mockProducts.add(mockGuitar);
        mockProducts.add(mockGuitar2);
        GuitarResponse guitarResponse1 = GuitarResponse.builder()
                .id(mockGuitar.getId())
                .name(mockGuitar.getName())
                .price(mockGuitar.getPrice())
                .type(mockGuitar.getType())
                .build();
        GuitarResponse guitarResponse2 = GuitarResponse.builder()
                .id(mockGuitar2.getId())
                .name(mockGuitar2.getName())
                .price(mockGuitar2.getPrice())
                .type(mockGuitar2.getType())
                .build();

        when(productRepository.findByCategory("guitars")).thenReturn(mockProducts);
        when(productMapper.mapToProductListResponse(mockProducts)).thenReturn(
                ProductListResponse.builder()
                        .guitars(List.of(guitarResponse1, guitarResponse2))
                        .build());
        ProductListResponse response = productService.getAllByCategory("guitars", "acoustic");

        assertEquals(2, response.guitars().size());
        assertEquals("acoustic", response.guitars().get(0).type());

    }

}