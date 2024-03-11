package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record PicksResponse(UUID id, String name, double price, List<Image> images, int rating, int product_quantity,
                            String category, String delivery_quantity, double thickness, String brandName, String brandLogo) {
}