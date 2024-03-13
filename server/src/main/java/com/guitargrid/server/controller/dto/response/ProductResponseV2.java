package com.guitargrid.server.controller.dto.response;

import com.guitargrid.server.model.Image;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record ProductResponseV2(UUID id, String name, double price, int rating, int product_quantity, String category,
                                List<Image> images, String brandName, String brandLogo) {

}
