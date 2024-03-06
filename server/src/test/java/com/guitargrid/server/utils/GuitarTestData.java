package com.guitargrid.server.utils;

import com.guitargrid.server.controller.dto.request.GuitarRequest;
import com.guitargrid.server.controller.dto.response.GuitarResponse;
import com.guitargrid.server.model.products.Guitar;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class GuitarTestData {

    public static final String BASE_URL_GUITARS = "/api/v1/guitars";

    public static final UUID GUITAR_ID = UUID.randomUUID();
    public static final String GUITAR_NAME = "Stratocaster";
    public static final int GUITAR_PRICE = 100;
    public static final String GUITAR_TYPE = "electric";
    public static final String GUITAR_COLOR = "Sunburst";
    public static final String GUITAR_BODY_TYPE = "Maple";
    public static final String GUITAR_NECK_TYPE = "Maple";
    public static final String GUITAR_FRETBOARD_TYPE = "Maple";
    public static final String GUITAR_PICKUPS = "Single Coil";
    public static final int GUITAR_SCALE = 255;
    public static final int GUITAR_FRETS = 22;

    public static GuitarRequest createGuitarRequest() {
        return GuitarRequest.builder()
                .name(GUITAR_NAME)
                .price(GUITAR_PRICE)
                .type(GUITAR_TYPE)
                .color(GUITAR_COLOR)
                .bodyType(GUITAR_BODY_TYPE)
                .neckType(GUITAR_NECK_TYPE)
                .fretboardType(GUITAR_FRETBOARD_TYPE)
                .pickups(GUITAR_PICKUPS)
                .scale(GUITAR_SCALE)
                .frets(GUITAR_FRETS)
                .build();
    }

    public static Guitar createElectricGuitarEntity() {
        return Guitar.builder()
                .name(GUITAR_NAME)
                .price(GUITAR_PRICE)
                .type(GUITAR_TYPE)
                .color(GUITAR_COLOR)
                .bodyType(GUITAR_BODY_TYPE)
                .neckType(GUITAR_NECK_TYPE)
                .fretboardType(GUITAR_FRETBOARD_TYPE)
                .pickups(GUITAR_PICKUPS)
                .scale(GUITAR_SCALE)
                .frets(GUITAR_FRETS)
                .build();
    }

    public static Guitar createAcousticGuitarEntity() {
        return Guitar.builder()
                .name(GUITAR_NAME)
                .price(GUITAR_PRICE)
                .type("acoustic")
                .color(GUITAR_COLOR)
                .bodyType(GUITAR_BODY_TYPE)
                .neckType(GUITAR_NECK_TYPE)
                .fretboardType(GUITAR_FRETBOARD_TYPE)
                .pickups(GUITAR_PICKUPS)
                .scale(GUITAR_SCALE)
                .frets(GUITAR_FRETS)
                .build();
    }
    public static GuitarResponse createGuitarResponse() {
        return GuitarResponse.builder()
                .id(GUITAR_ID)
                .name(GUITAR_NAME)
                .price(GUITAR_PRICE)
                .type(GUITAR_TYPE)
                .color(GUITAR_COLOR)
                .bodyType(GUITAR_BODY_TYPE)
                .neckType(GUITAR_NECK_TYPE)
                .fretboardType(GUITAR_FRETBOARD_TYPE)
                .pickups(GUITAR_PICKUPS)
                .scale(GUITAR_SCALE)
                .frets(GUITAR_FRETS)
                .build();
    }

}
