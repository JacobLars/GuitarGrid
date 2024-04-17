package com.guitargrid.server.model.products;

import com.guitargrid.server.model.Brand;
import com.guitargrid.server.model.Image;
import com.guitargrid.server.model.cart.CartProduct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

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
    private String category;

    @ManyToOne
    private Brand brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Image> images;

    public Product(String name, double price, int rating, int product_quantity, String category) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.product_quantity = product_quantity;
        this.category = category;
    }

}