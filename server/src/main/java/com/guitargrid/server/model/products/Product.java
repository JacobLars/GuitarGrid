package com.guitargrid.server.model.products;

import com.guitargrid.server.model.Brand;
import com.guitargrid.server.model.Image;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private double price;
    private int rating;
    private int product_quantity;
    @ManyToOne
    private Brand brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> images;
    public Product(String name, double price, int rating, int product_quantity) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.product_quantity = product_quantity;
    }
}