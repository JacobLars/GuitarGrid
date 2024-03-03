package com.guitargrid.server.controller;

import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.controller.dto.response.TunerListResponse;
import com.guitargrid.server.model.products.Tuner;
import com.guitargrid.server.service.TunerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/tuners")
@CrossOrigin
public class TunerController {

    private final TunerService service;

    @PostMapping("/{brandId}")
    @ResponseStatus(CREATED)
    public Tuner saveTuner(@RequestBody TunerRequest tunerRequest, @PathVariable UUID brandId) {
        return service.saveTuner(tunerRequest, brandId);
    }

    @GetMapping
    public TunerListResponse getAllTuners() {
        return service.getAllTuners();
    }

}
