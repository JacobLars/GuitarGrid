package com.guitargrid.server.model.cart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class Cart {

    @Id
    @UuidGenerator
    private UUID id;

}
