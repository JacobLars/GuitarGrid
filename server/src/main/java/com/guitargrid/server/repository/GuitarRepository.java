package com.guitargrid.server.repository;

import com.guitargrid.server.model.products.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GuitarRepository extends JpaRepository<Guitar, UUID> {
    List<Guitar> findAllByType(String type);
}
