package com.guitargrid.server.model;

import com.guitargrid.server.model.products.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Brand {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String logo;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Product> product;

    void addProduct(Product product) {
        this.product.add(product);
    }

}
