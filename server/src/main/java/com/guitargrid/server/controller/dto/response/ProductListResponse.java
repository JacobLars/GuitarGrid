package com.guitargrid.server.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@JsonInclude(NON_NULL)
public record ProductListResponse(List<GuitarResponse> guitars, List<TunerResponse> tuners) {
}
