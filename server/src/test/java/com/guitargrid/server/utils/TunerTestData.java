package com.guitargrid.server.utils;

import com.guitargrid.server.controller.dto.request.TunerRequest;
import com.guitargrid.server.controller.dto.response.TunerListResponse;
import com.guitargrid.server.controller.dto.response.TunerResponse;
import com.guitargrid.server.model.products.Tuner;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class TunerTestData {

    public static final String BASE_URL_TUNERS = "/api/v1/tuners";
    public static final UUID TUNER_ID = UUID.randomUUID();
    public static final String TUNER_NAME = "Tuner";
    public static final int TUNER_PRICE = 100;
    public static int TUNER_RATING = 5;
    public static int TUNER_PRODUCT_QUANTITY = 10;
    public static String TUNER_DISPLAY = "LCD";
    public static String TUNER_DESIGN = "Clip-on";
    public static boolean TUNER_CHROMATIC = true;
    public static boolean TUNER_INTEGRATED_METRONOME = true;
    public static boolean TUNER_INTEGRATED_MICROPHONE = true;
    public static String TUNER_CATEGORY = "Tuner";

    public static TunerRequest createTunerRequest(){
        return TunerRequest.builder()
                .name(TUNER_NAME)
                .price(TUNER_PRICE)
                .rating(TUNER_RATING)
                .product_quantity(TUNER_PRODUCT_QUANTITY)
                .display(TUNER_DISPLAY)
                .design(TUNER_DESIGN)
                .chromatic(TUNER_CHROMATIC)
                .integrated_metronome(TUNER_INTEGRATED_METRONOME)
                .integrated_microphone(TUNER_INTEGRATED_MICROPHONE)
                .category(TUNER_CATEGORY)
                .build();
    }
    public static Tuner createTunerEntity() {
        return Tuner.builder()
                .name(TUNER_NAME)
                .price(TUNER_PRICE)
                .rating(TUNER_RATING)
                .product_quantity(TUNER_PRODUCT_QUANTITY)
                .display(TUNER_DISPLAY)
                .design(TUNER_DESIGN)
                .chromatic(TUNER_CHROMATIC)
                .integrated_metronome(TUNER_INTEGRATED_METRONOME)
                .integrated_microphone(TUNER_INTEGRATED_MICROPHONE)
                .category(TUNER_CATEGORY)
                .build();
    }

    public static TunerResponse createTunerResponse() {
        return TunerResponse.builder()
                .id(TUNER_ID)
                .name(TUNER_NAME)
                .price(TUNER_PRICE)
                .rating(TUNER_RATING)
                .product_quantity(TUNER_PRODUCT_QUANTITY)
                .display(TUNER_DISPLAY)
                .design(TUNER_DESIGN)
                .chromatic(TUNER_CHROMATIC)
                .integrated_metronome(TUNER_INTEGRATED_METRONOME)
                .integrated_microphone(TUNER_INTEGRATED_MICROPHONE)
                .category(TUNER_CATEGORY)
                .build();
    }


}