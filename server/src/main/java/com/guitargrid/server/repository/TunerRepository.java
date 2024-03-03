package com.guitargrid.server.repository;

import com.guitargrid.server.model.products.Tuner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TunerRepository extends JpaRepository<Tuner, UUID> {
}
