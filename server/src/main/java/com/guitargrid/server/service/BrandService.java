package com.guitargrid.server.service;

import com.guitargrid.server.controller.dto.request.BrandRequest;
import com.guitargrid.server.controller.dto.response.BrandResponse;
import com.guitargrid.server.mapper.BrandMapper;
import com.guitargrid.server.model.Brand;
import com.guitargrid.server.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;
    public BrandResponse saveBrand(BrandRequest brandRequest) {
        return brandMapper.mapToBrandResponse(brandRepository.save(brandMapper.mapToBrand(brandRequest)));
    }

    public BrandResponse getBrandById(UUID id) {
        return brandMapper.mapToBrandResponse(brandRepository.findById(id).orElseThrow());
    }

}
