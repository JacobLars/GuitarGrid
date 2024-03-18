package com.guitargrid.server.model.cart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class CartProduct {

    @Id
    @UuidGenerator
    private UUID id;

    private int quantity;
    private double totalPrice;
    @ManyToOne
    private Cart cart;

}
