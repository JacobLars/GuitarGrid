package com.guitargrid.server.service;

import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.mapper.TunerMapper;
import com.guitargrid.server.model.products.Tuner;
import com.guitargrid.server.repository.BrandRepository;
import com.guitargrid.server.repository.TunerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TunerService {

    private final TunerRepository tunerRepository;
    private final BrandRepository brandRepository;
    private final TunerMapper tunerMapper;
    public Tuner saveTuner(TunerRequest tunerRequest, UUID brandId) {
        Tuner tuner = tunerMapper.mapToTuner(tunerRequest);
        tunerRepository.save(tuner);
        tunerRequest.images().forEach(image -> image.setProduct(tuner));
        tuner.setImages(tunerRequest.images());
        tuner.setBrand(brandRepository.findById(brandId).orElse(null));
        return tunerRepository.save(tuner);
    }

}
