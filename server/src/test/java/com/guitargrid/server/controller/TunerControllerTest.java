package com.guitargrid.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.controller.dto.response.TunerListResponse;
import com.guitargrid.server.service.TunerService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.guitargrid.server.utils.GuitarTestData.*;
import static com.guitargrid.server.utils.TunerTestData.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TunerController.class)
class TunerControllerTest {

    @MockBean
    private TunerService tunerService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void shouldSaveTunerAndHaveStatus201Created() {
        TunerRequest tunerRequest = createTunerRequest();
        when(tunerService.saveTuner(tunerRequest, TUNER_ID)).thenReturn(createTunerResponse());
        mockMvc.perform(post(BASE_URL_TUNERS + "/" + TUNER_ID)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(tunerRequest)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(tunerRequest.name()));
    }

    @Test
    @SneakyThrows
    void shouldReturnListOfTunersAndHaveStatus200Ok() {
        TunerListResponse tunerListResponse = TunerListResponse.builder().tuners(List.of(createTunerResponse())).build();
        when(tunerService.getAllTuners()).thenReturn(tunerListResponse);
        mockMvc.perform(get(BASE_URL_TUNERS))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tuners[0].name")
                        .value(tunerListResponse.tuners().get(0).name()));
    }

}