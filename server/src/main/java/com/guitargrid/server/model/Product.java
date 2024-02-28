package com.guitargrid.server.model;

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
    private String brand;

    @OneToMany(mappedBy = "product")
    List<Image> images;
    public Product(String name, double price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }
    public void addImage(Image image) {
        images.add(image);
    }
}