package com.guitargrid.server.controller;

import com.guitargrid.server.controller.dto.request.BrandRequest;
import com.guitargrid.server.controller.dto.response.BrandListResponse;
import com.guitargrid.server.controller.dto.response.BrandResponse;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/brands")
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    @ResponseStatus(CREATED)
    public BrandResponse saveBrand(@RequestBody BrandRequest brandRequest) {
       return brandService.saveBrand(brandRequest);
    }

    @GetMapping("/{id}")
    public BrandResponse getBrandById(@PathVariable UUID id) {
        return brandService.getBrandById(id);
    }

    @GetMapping
    public BrandListResponse getAllBrands() {
        return brandService.getAllBrands();
    }

}
