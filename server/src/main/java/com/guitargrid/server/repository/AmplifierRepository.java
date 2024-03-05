package com.guitargrid.server.repository;

import com.guitargrid.server.model.products.Amplifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AmplifierRepository extends JpaRepository<Amplifier, UUID> {
}
