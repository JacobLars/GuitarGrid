package com.guitargrid.server.service;

import com.guitargrid.server.model.products.Guitar;
import com.guitargrid.server.repository.GuitarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GuitarService {


    private final GuitarRepository guitarRepository;
    private final BrandService brandService;

    public Guitar saveGuitar(Guitar guitar, UUID brandId) {
        guitar.setBrand(brandService.getBrandById(brandId));
       return guitarRepository.save(guitar);
    }

    public List<Guitar> getAllGuitars() {
        return guitarRepository.findAll();
    }



}
