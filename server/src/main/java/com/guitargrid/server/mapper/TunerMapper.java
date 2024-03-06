package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.controller.dto.response.TunerListResponse;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.model.products.Tuner;
import org.springframework.stereotype.Component;

import java.util.List;

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
                .category(tunerRequest.category())
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
