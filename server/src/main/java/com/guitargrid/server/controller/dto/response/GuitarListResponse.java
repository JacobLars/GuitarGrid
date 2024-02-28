package com.guitargrid.server.controller.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record GuitarListResponse(List<GuitarResponse> guitars) {
}
