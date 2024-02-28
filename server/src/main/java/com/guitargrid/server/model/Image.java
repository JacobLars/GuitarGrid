package com.guitargrid.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class Image {

    @Id
    @UuidGenerator
    private UUID id;
    private String url;

    @ManyToOne
    private Product product;


}
