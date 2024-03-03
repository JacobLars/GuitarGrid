package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.model.products.Tuner;
import org.springframework.stereotype.Component;

@Component
public class TunerMapper {

    public Tuner mapToTuner(TunerRequest tunerRequest) {
        return Tuner.builder()
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
    }

}
