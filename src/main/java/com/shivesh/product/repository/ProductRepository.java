package com.shivesh.product.repository;

import com.shivesh.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository<Product, Long> means:
 * - This repository will manage 'Product' entities.
 * - The primary key of the 'Product' entity is of type 'Long'.
 * (If your product's ID is an Integer or String, change 'Long' accordingly).
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring Data JPA automatically provides the save() method,
    // so you don't need to write it here.
    // You can add custom find methods later, like:
    // Product findByName(String name);
}
