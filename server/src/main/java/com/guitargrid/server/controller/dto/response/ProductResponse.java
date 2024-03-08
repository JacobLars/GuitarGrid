package com.guitargrid.server.controller.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@JsonInclude(NON_NULL)
public record ProductResponse(GuitarResponse guitar, TunerResponse tuner, AmplifierResponse amplifier,
                              PickupResponse pickup, PicksResponse picks) {
}
