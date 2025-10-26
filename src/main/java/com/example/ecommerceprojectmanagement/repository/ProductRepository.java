package com.example.ecommerceprojectmanagement.repository;

import com.example.productmanagementsystem1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query using JPQL
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findProductsByPriceGreaterThan(double price);
}
