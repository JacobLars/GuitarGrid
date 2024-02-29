package com.guitargrid.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guitargrid.server.model.products.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Image {

    @Id
    @UuidGenerator
    private UUID id;
    private String url;
    private Boolean isMain;

    @ManyToOne
    @JsonIgnore
    private Product product;


}
