package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.model.products.Tuner;
import org.springframework.stereotype.Component;

@Component
public class TunerMapper {

    public Tuner mapToTuner(TunerRequest tunerRequest) {
        return Tuner.builder()
                .name(tunerRequest.getName())
                .price(tunerRequest.getPrice())
                .display(tunerRequest.getDisplay())
                .design(tunerRequest.getDesign())
                .chromatic(tunerRequest.getChromatic())
                .integrated_metronome(tunerRequest.getIntegrated_metronome())
                .integrated_microphone(tunerRequest.getIntegrated_microphone())
                .rating(tunerRequest.getRating())
                .product_quantity(tunerRequest.getProduct_quantity())
                .category(tunerRequest.getCategory())
                .build();
    }

    public TunerResponse mapToTunerResponse(Tuner tuner) {
        return TunerResponse.builder()
                .id(tuner.getId())
                .name(tuner.getName())
                .price(tuner.getPrice())
                .display(tuner.getDisplay())
                .design(tuner.getDesign())
                .chromatic(tuner.getChromatic())
                .integrated_metronome(tuner.getIntegrated_metronome())
                .integrated_microphone(tuner.getIntegrated_microphone())
                .images(tuner.getImages())
                .brandName(tuner.getBrand().getName())
                .brandLogo(tuner.getBrand().getLogo())
                .rating(tuner.getRating())
                .product_quantity(tuner.getProduct_quantity())
                .category(tuner.getCategory())
                .build();
    }

}
