package com.guitargrid.server.service;

import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.response.GuitarListResponse;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.mapper.GuitarMapper;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.repository.BrandRepository;
import com.guitargrid.server.repository.GuitarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GuitarService {

    private final GuitarRepository guitarRepository;
    private final BrandRepository brandRepository;
    private final GuitarMapper guitarMapper;

    public GuitarResponse saveGuitar(GuitarRequest guitarRequest, UUID brandId) {
        Guitar guitar = guitarRepository.save(guitarMapper.mapToGuitar(guitarRequest));
        guitarRequest.images().forEach(image -> image.setProduct(guitar));
        guitar.setImages(guitarRequest.images());
        guitar.setBrand(brandRepository.findById(brandId).orElse(null));
        guitarRepository.save(guitar);
       return guitarMapper.mapToGuitarResponse(guitar);
    }

    public GuitarListResponse getAllGuitars() {
        return guitarMapper.mapToGuitarListResponse(guitarRepository.findAll());
    }


    public GuitarResponse getGuitarById(UUID id) {
        return guitarMapper.mapToGuitarResponse(
                guitarRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Guitar not found")));
    }

    public GuitarListResponse getGuitarsByType(String guitarType) {
        return guitarMapper.mapToGuitarListResponse(guitarRepository.findAllByType(guitarType));
    }
}
