package com.guitargrid.server.service;

import com.guitargrid.server.controller.dto.request.TunerRequest;
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
    public Tuner saveTuner(TunerRequest tunerRequest, UUID brandId) {
        Tuner tuner = Tuner.builder()
                .name(tunerRequest.name())
                .price(tunerRequest.price())
                .display(tunerRequest.display())
                .design(tunerRequest.design())
                .chromatic(tunerRequest.chromatic())
                .integrated_metronome(tunerRequest.integrated_metronome())
                .integrated_microphone(tunerRequest.integrated_microphone())
                .rating(tunerRequest.rating())
                .product_quantity(tunerRequest.product_quantity())
                .build();
        tunerRepository.save(tuner);
        tunerRequest.images().forEach(image -> image.setProduct(tuner));
        tuner.setImages(tunerRequest.images());
        tuner.setBrand(brandRepository.findById(brandId).orElse(null));
        return tunerRepository.save(tuner);
    }

}
