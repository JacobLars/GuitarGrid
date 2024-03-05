package com.guitargrid.server.service;

import com.guitargrid.server.model.products.Amplifier;
import com.guitargrid.server.model.products.Product;
import com.guitargrid.server.repository.AmplifierRepository;
import com.guitargrid.server.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AmplifierService {

    private final AmplifierRepository amplifierRepository;
    private final BrandRepository brandRepository;

    public List<Amplifier> getAllAmplifiers() {
        return amplifierRepository.findAll();
    }

    public Amplifier saveAmplifier(Amplifier amplifier, UUID brandId) {
        amplifier.setBrand(brandRepository.findById(brandId).orElse(null));
        amplifier.getImages().forEach(image -> image.setProduct(amplifier));
        return amplifierRepository.save(amplifier);
    }

}
