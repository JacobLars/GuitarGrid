package com.guitargrid.server.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.controller.dto.request.BrandRequest;
import com.guitargrid.server.controller.dto.response.BrandListResponse;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.service.BrandService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.guitargrid.server.utils.BrandTestData.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BrandController.class)
class BrandControllerTest {

    @MockBean
    private BrandService brandService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void shouldSaveBrandAndHaveStatus201Created() {
        BrandRequest brandRequest = createBrandRequest();
        when(brandService.saveBrand(brandRequest)).thenReturn(createBrandResponse());
        mockMvc.perform(post(BASE_URL_BRANDS)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(brandRequest)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(brandRequest.name()));
    }

    @Test
    @SneakyThrows
    void shouldGetAllBrandsAndHaveStatus200Ok() {
        BrandListResponse brandListResponse = BrandListResponse.builder().brands(List.of(createBrandResponse())).build();
        when(brandService.getAllBrands()).thenReturn(brandListResponse);
        mockMvc.perform(get(BASE_URL_BRANDS))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brands[0].name")
                        .value(brandListResponse.brands().get(0).name()));
    }
    @Test
    @SneakyThrows
    void shouldGetBrandByIdAndHaveStatus200Ok() {
        Brand brand = createNewBrandEntity();
        when(brandService.getBrandById(brand.getId())).thenReturn(createBrandResponse());
        mockMvc.perform(get(BASE_URL_BRANDS + "/" + BRAND_ID))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(brand.getId().toString()));
    }
}