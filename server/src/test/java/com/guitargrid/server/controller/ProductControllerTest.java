package com.guitargrid.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.controller.dto.response.ProductListResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.controller.dto.response.TunerResponse;
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

import static com.guitargrid.server.utils.BrandTestData.createNewBrandEntity;
import static com.guitargrid.server.utils.GuitarTestData.createElectricGuitarEntity;
import static com.guitargrid.server.utils.GuitarTestData.createElectricGuitarResponse;
import static com.guitargrid.server.utils.ProductTestData.*;
import static com.guitargrid.server.utils.TunerTestData.createTunerResponse;
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
                .andExpect(jsonPath("$.tuners").doesNotExist());
    }

}
