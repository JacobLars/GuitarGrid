package com.guitargrid.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.exception.ProductNotFoundException;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.service.ProductService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static com.guitargrid.server.utils.BrandTestData.createNewBrandEntity;
import static com.guitargrid.server.utils.GuitarTestData.*;
import static com.guitargrid.server.utils.ProductTestData.*;
import static com.guitargrid.server.utils.TunerTestData.createTunerResponse;
import static java.lang.String.format;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void shouldSaveNewProductAndHaveStatus201Created() {
        Product request = createElectricGuitarEntity();
        GuitarResponse guitarResponse = createElectricGuitarResponse();
        ProductResponse response = createProductResponseWithGuitar(guitarResponse);
        Brand brand = createNewBrandEntity();
        when(productService.handleRequest(objectMapper.writeValueAsString(request), brand.getId()))
                .thenReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL_PRODUCTS + "/" + brand.getId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.guitar.name").value(response.guitar().name()));
    }

    @Test
    @SneakyThrows
    void shouldGetAllTunersByCategoryAndHaveStatus200Ok() {
        TunerResponse tunerResponse = createTunerResponse();
        ProductListResponse productListResponse = createProductListResponseWithTuners(tunerResponse);
        when(productService.getQueriedProducts("tuners", null))
                .thenReturn(productListResponse);
        mockMvc.perform(get(BASE_URL_PRODUCTS + "?category=tuners"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tuners[0].name")
                        .value(productListResponse.tuners().get(0).name()))
                .andExpect(jsonPath("$.guitars").doesNotExist());
    }

    @Test
    @SneakyThrows
    void shouldGetAllElectricGuitarsByCategoryAndTypeAndHaveStatus200Ok(){
        GuitarResponse guitarResponse = createElectricGuitarResponse();
        ProductListResponse productListResponse = createProductListResponseWithGuitars(guitarResponse);
        when(productService.getQueriedProducts("guitars", "electric"))
                .thenReturn(productListResponse);
        mockMvc.perform(get(BASE_URL_PRODUCTS + "?category=guitars&type=electric"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.guitars[0].name")
                        .value(productListResponse.guitars().get(0).name()))
                .andExpect(jsonPath("$.guitars[0].type")
                        .value("electric"))
                .andExpect(jsonPath("$.tuners").doesNotExist());
    }

    @Test
    @SneakyThrows
    void shouldGetAcousticGuitarsByCategoryAndTypeAndHaveStatus200Ok(){
        GuitarResponse guitarResponse = createAcousticGuitarResponse();
        ProductListResponse productListResponse = createProductListResponseWithGuitars(guitarResponse);
        when(productService.getQueriedProducts("guitars", "acoustic"))
                .thenReturn(productListResponse);
        mockMvc.perform(get(BASE_URL_PRODUCTS + "?category=guitars&type=acoustic"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.guitars[0].name")
                        .value(productListResponse.guitars().get(0).name()))
                .andExpect(jsonPath("$.guitars[0].type")
                        .value("acoustic"))

                .andExpect(jsonPath("$.tuners").doesNotExist());
    }

    @Test
    @SneakyThrows
    void shouldFindProductByIdAndHaveStatus200Ok() {
        GuitarResponse guitarResponse = createElectricGuitarResponse();
        ProductResponse productResponse = createProductResponseWithGuitar(guitarResponse);
        when(productService.getProductById(guitarResponse.id()))
                .thenReturn(productResponse);
        mockMvc.perform(get(BASE_URL_PRODUCTS + "/" + guitarResponse.id()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.guitar.name")
                        .value(productResponse.guitar().name()));
    }

    @Test
    @SneakyThrows
    void shouldReturnNotFoundStatusWhenProductIsNotFound() {
        UUID id = UUID.fromString("ba191c98-4f3a-4eef-b214-ccfde594ba4");
        String message = format("Product with id %s not found", id);
         when(productService.getProductById(id))
                .thenThrow(new ProductNotFoundException(id));
        mockMvc.perform(get(BASE_URL_PRODUCTS + "/" + id))
                .andExpect(status().isNotFound())
                .andExpect(content().string(message));
    }
}
