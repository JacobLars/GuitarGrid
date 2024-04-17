package com.guitargrid.server.model.cart;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Table(name = "cart_product")
public class CartProduct {

    @Id
    @UuidGenerator
    private String id;
    private String name;
    private int quantity;
    private double price;

}
