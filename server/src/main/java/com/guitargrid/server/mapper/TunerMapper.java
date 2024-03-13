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

    public TunerResponse mapToTunerResponse(Tuner product) {
        return TunerResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .display(product.getDisplay())
                .design(product.getDesign())
                .chromatic(product.getChromatic())
                .integrated_metronome(product.getIntegrated_metronome())
                .integrated_microphone(product.getIntegrated_microphone())
                .images(product.getImages())
                .brandName(product.getBrand().getName())
                .brandLogo(product.getBrand().getLogo())
                .rating(product.getRating())
                .product_quantity(product.getProduct_quantity())
                .category(product.getCategory())
                .build();
    }
}
