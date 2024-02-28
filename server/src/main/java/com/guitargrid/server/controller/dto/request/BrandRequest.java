package com.guitargrid.server.controller.dto.request;

import lombok.Builder;

@Builder
public record BrandRequest(String name, String logo) {
}
