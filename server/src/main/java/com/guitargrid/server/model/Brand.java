package com.guitargrid.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

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
}
