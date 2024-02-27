package com.guitargrid.server.model;

import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Guitar extends Product{

    private String type;

    private String color;



}
