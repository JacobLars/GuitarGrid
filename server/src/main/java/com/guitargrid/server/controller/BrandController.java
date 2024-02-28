package com.guitargrid.server.controller;

import com.guitargrid.server.model.Brand;
import com.guitargrid.server.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/brands")
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    public Brand saveBrand(@RequestBody Brand brand) {
       return brandService.saveBrand(brand);
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable UUID id) {
        return brandService.getBrandById(id);
    }

}
