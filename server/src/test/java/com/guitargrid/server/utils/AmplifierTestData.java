package com.guitargrid.server.utils;

import com.guitargrid.server.controller.dto.request.AmplifierRequest;
import com.guitargrid.server.model.Image;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class AmplifierTestData {

    public static final String AMPLIFIER_NAME = "Amplifier";
    public static final int AMPLIFIER_PRICE = 100;
    public static final String AMPLIFIER_CATEGORY = "amplifier";
    public static final int PRODUCT_QUANTITY = 2;
    public static final int AMPLIFIER_RATING = 5;
    public static final double AMPLIFIER_WEIGHT = 10.0;
    public static final int AMPLIFIER_POWER = 100;
    public static final int AMPLIFIER_CHANNELS = 2;
    public static final Boolean AMPLIFIER_REVERB = true;
    public static final Boolean AMPLIFIER_EXTERNAL_FX_LOOP = true;
    public static final Boolean AMPLIFIER_LINE_INPUT = true;
    public static final Boolean AMPLIFIER_FOOT_SWITCH_CONNECTION = true;
    public static final Boolean AMPLIFIER_EFFECTS_PROCESSOR = true;
    public static final Boolean AMPLIFIER_MICROPHONE_INPUT = true;
    public static final Boolean AMPLIFIER_BATTERY_OPERATION = true;

    public static final List<Image> AMPLIFIER_IMAGES = new ArrayList<Image>();
    public static AmplifierRequest createAmplifierRequest () {
        return new AmplifierRequest(AMPLIFIER_NAME, AMPLIFIER_PRICE, AMPLIFIER_IMAGES, AMPLIFIER_RATING,
                PRODUCT_QUANTITY, AMPLIFIER_CATEGORY, AMPLIFIER_WEIGHT, AMPLIFIER_POWER, AMPLIFIER_CHANNELS,
                AMPLIFIER_REVERB, AMPLIFIER_EXTERNAL_FX_LOOP, AMPLIFIER_LINE_INPUT, AMPLIFIER_FOOT_SWITCH_CONNECTION,
                AMPLIFIER_EFFECTS_PROCESSOR, AMPLIFIER_MICROPHONE_INPUT, AMPLIFIER_BATTERY_OPERATION);
    }



}
