package com.guitargrid.server.service;

import com.guitargrid.server.model.Guitar;
import com.guitargrid.server.repository.GuitarRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarService {


    private final GuitarRepository guitarRepository;

    public GuitarService(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }


    public Guitar saveGuitar(Guitar guitar) {
       return guitarRepository.save(guitar);
    }

    public List<Guitar> getAllGuitars() {
        return guitarRepository.findAll();
    }



}
