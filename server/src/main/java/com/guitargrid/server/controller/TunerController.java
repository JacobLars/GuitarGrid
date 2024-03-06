package com.guitargrid.server.controller;

import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.controller.dto.response.TunerResponse;
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

/*    @PostMapping("/{brandId}")
    @ResponseStatus(CREATED)
    public TunerResponse saveTuner(@RequestBody TunerRequest tunerRequest, @PathVariable UUID brandId) {
        return service.saveTuner(tunerRequest, brandId);
    }*/

}
