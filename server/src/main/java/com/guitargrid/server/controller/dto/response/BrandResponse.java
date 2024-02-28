package com.guitargrid.server.controller.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record BrandResponse(UUID id, String name, String logo) {
}
