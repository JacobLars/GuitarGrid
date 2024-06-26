package com.guitargrid.server.service;

import com.guitargrid.server.controller.dto.request.BrandRequest;
import com.guitargrid.server.controller.dto.response.BrandListResponse;
import com.guitargrid.server.controller.dto.response.BrandResponse;
import com.guitargrid.server.mapper.BrandMapper;
import com.guitargrid.server.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandResponse saveBrand(BrandRequest brandRequest) {
        return brandMapper.mapToBrandResponse(brandRepository.save(brandMapper.mapToBrand(brandRequest)));
    }



    public BrandListResponse getAllBrands() {
        return brandMapper.mapToBrandListResponse(brandRepository.findAll());
    }
}
