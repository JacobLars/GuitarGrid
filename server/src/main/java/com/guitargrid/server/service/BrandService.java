package com.guitargrid.server.service;

import com.guitargrid.server.model.Brand;
import com.guitargrid.server.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand getBrandById(UUID id) {
        return brandRepository.findById(id).orElse(null);
    }

}
