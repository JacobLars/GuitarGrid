package com.guitargrid.server.mapper;

import com.guitargrid.server.controller.dto.response.AmplifierResponse;
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

    public AmplifierResponse mapToAmplifierResponse(Amplifier amplifier) {
        return AmplifierResponse.builder()
                .id(amplifier.getId())
                .price(amplifier.getPrice())
                .rating(amplifier.getRating())
                .product_quantity(amplifier.getProduct_quantity())
                .category(amplifier.getCategory())
                .weight(amplifier.getWeight())
                .power(amplifier.getPower())
                .channels(amplifier.getChannels())
                .reverb(amplifier.getReverb())
                .externalFxLoop(amplifier.getExternalFxLoop())
                .lineInput(amplifier.getLineInput())
                .footSwitchConnection(amplifier.getFootSwitchConnection())
                .effectsProcessor(amplifier.getEffectsProcessor())
                .microphoneInput(amplifier.getMicrophoneInput())
                .batteryOperation(amplifier.getBatteryOperation())
                .build();
    }

}
