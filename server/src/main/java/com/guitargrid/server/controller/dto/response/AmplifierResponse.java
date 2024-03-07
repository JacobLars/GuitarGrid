package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;

import java.util.List;
import java.util.UUID;

public record AmplifierResponse(UUID id, double price, List<Image> images, int rating, int product_quantity, String category,
                                double weight, int power, int channels, Boolean reverb, Boolean externalFxLoop,
                                Boolean lineInput, Boolean footSwitchConnection, Boolean effectsProcessor,
                                Boolean microphoneInput, Boolean batteryOperation, String brandName, String brandLogo) {
}
