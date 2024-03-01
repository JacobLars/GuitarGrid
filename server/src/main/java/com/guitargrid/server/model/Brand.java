package com.guitargrid.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guitargrid.server.model.products.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Brand {

    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private String logo;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> product;

}
