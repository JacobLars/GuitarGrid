package com.guitargrid.server.exception;

import java.util.UUID;

import static java.lang.String.format;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(UUID id) {
        super(format("Product with id %s not found", id));
    }
}
