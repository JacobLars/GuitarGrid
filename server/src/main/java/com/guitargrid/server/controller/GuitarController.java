package com.guitargrid.server.controller;

import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.service.GuitarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/guitars")
public class GuitarController {


    private final GuitarService guitarService;

    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping
    public List<Guitar> getAllGuitars() {
        return guitarService.getAllGuitars();
    }

    @PostMapping("/{brandId}")
    public Guitar saveGuitar(@RequestBody Guitar guitar, @PathVariable UUID brandId) {
        return guitarService.saveGuitar(guitar, brandId);
    }




}
