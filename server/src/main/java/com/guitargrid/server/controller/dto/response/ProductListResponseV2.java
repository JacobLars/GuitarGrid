package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.products.Product;
import lombok.Builder;

import java.util.List;

@Builder
public record ProductListResponseV2(List<ProductResponseV2> products) {
}
