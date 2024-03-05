package com.guitargrid.server.controller.dto.request;

import com.guitargrid.server.model.Image;
import lombok.Builder;

import java.util.List;

@Builder
public record ProductRequest(String name, double price, List<Image> images, int rating, int product_quantity, String category) {
}
