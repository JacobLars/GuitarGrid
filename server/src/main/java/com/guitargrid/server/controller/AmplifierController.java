package com.guitargrid.server.controller;

import com.guitargrid.server.model.products.Amplifier;
import com.guitargrid.server.service.AmplifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/amplifiers")
public class AmplifierController {

    private final AmplifierService amplifierService;

    @PostMapping("/{brandId}")
    public Amplifier saveAmplifier(@RequestBody Amplifier amplifier, @PathVariable UUID brandId) {
        return amplifierService.saveAmplifier(amplifier, brandId);
    }
}
