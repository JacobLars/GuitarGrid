package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.response.AmplifierResponse;
import com.guitargrid.server.controller.dto.response.ProductResponse;
import com.guitargrid.server.model.products.Amplifier;
import org.springframework.stereotype.Component;

@Component
public class AmplifierMapper {

    public Amplifier mapToAmplifier(com.guitargrid.server.controller.dto.request.AmplifierRequest amplifierRequest) {
        return Amplifier.builder()
                .name(amplifierRequest.getName())
                .price(amplifierRequest.getPrice())
                .rating(amplifierRequest.getRating())
                .product_quantity(amplifierRequest.getProduct_quantity())
                .category(amplifierRequest.getCategory())
                .weight(amplifierRequest.getWeight())
                .power(amplifierRequest.getPower())
                .channels(amplifierRequest.getChannels())
                .reverb(amplifierRequest.getReverb())
                .externalFxLoop(amplifierRequest.getExternalFxLoop())
                .lineInput(amplifierRequest.getLineInput())
                .footSwitchConnection(amplifierRequest.getFootSwitchConnection())
                .effectsProcessor(amplifierRequest.getEffectsProcessor())
                .microphoneInput(amplifierRequest.getMicrophoneInput())
                .batteryOperation(amplifierRequest.getBatteryOperation())
                .build();
    }


    public ProductResponse mapToAmplifierResponse(Amplifier product) {
        return AmplifierResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .rating(product.getRating())
                .product_quantity(product.getProduct_quantity())
                .category(product.getCategory())
                .images(product.getImages())
                .brandName(product.getBrand().getName())
                .brandLogo(product.getBrand().getLogo())
                .weight(product.getWeight())
                .power(product.getPower())
                .channels(product.getChannels())
                .reverb(product.getReverb())
                .externalFxLoop(product.getExternalFxLoop())
                .lineInput(product.getLineInput())
                .footSwitchConnection(product.getFootSwitchConnection())
                .effectsProcessor(product.getEffectsProcessor())
                .microphoneInput(product.getMicrophoneInput())
                .batteryOperation(product.getBatteryOperation())
                .build();
    }
}
