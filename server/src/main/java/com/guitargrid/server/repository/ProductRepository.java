package com.guitargrid.server.repository;

import com.guitargrid.server.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>{
    List<Product> findByCategory(String category);
    List<Product> findByBrandId(UUID uuid);
}
