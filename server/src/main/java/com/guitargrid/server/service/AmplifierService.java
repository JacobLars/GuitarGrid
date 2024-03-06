package com.guitargrid.server.service;

import com.guitargrid.server.model.products.Amplifier;
import com.guitargrid.server.repository.BrandRepository;
import com.guitargrid.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AmplifierService {

    private final ProductRepository amplifierRepository;
    private final BrandRepository brandRepository;

    public Amplifier saveAmplifier(Amplifier amplifier, UUID brandId) {
        amplifier.setBrand(brandRepository.findById(brandId).orElse(null));
        amplifier.getImages().forEach(image -> image.setProduct(amplifier));
        return amplifierRepository.save(amplifier);
    }

}
