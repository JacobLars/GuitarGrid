package com.guitargrid.server.service;

import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.mapper.GuitarMapper;
import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.repository.BrandRepository;
import com.guitargrid.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GuitarService {

    private final ProductRepository guitarRepository;
    private final BrandRepository brandRepository;
    private final GuitarMapper guitarMapper;

/*    public GuitarResponse saveGuitar(GuitarRequest guitarRequest, UUID brandId) {
        Guitar guitar = guitarRepository.save(guitarMapper.mapToGuitar(guitarRequest));
        guitarRequest.images().forEach(image -> image.setProduct(guitar));
        guitar.setImages(guitarRequest.images());
        guitar.setBrand(brandRepository.findById(brandId).orElse(null));
        guitarRepository.save(guitar);
       return guitarMapper.mapToGuitarResponse(guitar);
    }*/

}
