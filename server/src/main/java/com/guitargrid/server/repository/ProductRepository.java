package com.guitargrid.server.repository;

import com.guitargrid.server.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository<T extends Product> extends JpaRepository<T, UUID>{
    List<T> findByCategory(String category);
}
