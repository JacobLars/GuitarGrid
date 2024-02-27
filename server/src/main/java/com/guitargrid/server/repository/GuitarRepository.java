package com.guitargrid.server.repository;

import com.guitargrid.server.model.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuitarRepository extends JpaRepository<Guitar, UUID> {
}
