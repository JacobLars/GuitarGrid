package com.guitargrid.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.response.GuitarListResponse;
import com.guitargrid.server.service.GuitarService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.guitargrid.server.utils.GuitarTestData.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GuitarController.class)
class GuitarControllerTest {

    @MockBean
    private GuitarService guitarService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void shouldSaveGuitarAndHaveStatus201Created() {
        GuitarRequest guitarRequest = createGuitarRequest();
        when(guitarService.saveGuitar(guitarRequest, GUITAR_ID)).thenReturn(createGuitarResponse());
        mockMvc.perform(post(BASE_URL_GUITARS + "/" + GUITAR_ID)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(guitarRequest)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(guitarRequest.name()));
    }

    @Test
    @SneakyThrows
    void shouldReturnListOfGuitarsAndHaveStatus200Ok() {
        GuitarListResponse guitarListResponse = GuitarListResponse.builder().guitars(List.of(createGuitarResponse())).build();
        when(guitarService.getAllGuitars()).thenReturn(guitarListResponse);
        mockMvc.perform(get(BASE_URL_GUITARS))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.guitars[0].name")
                        .value(guitarListResponse.guitars().get(0).name()));
    }

}