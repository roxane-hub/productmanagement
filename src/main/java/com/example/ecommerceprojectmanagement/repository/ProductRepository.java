package com.example.ecommerceprojectmanagement.repository;

import com.example.ecommerceprojectmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.price > ?1")
	List<Product> findProductsByPriceGreaterThan(double price);

	@Query("SELECT p FROM Product p WHERE p.category.name = ?1")
	List<Product> findProductsByCategoryName(String categoryName);

	@Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', ?1, '%'))")
	List<Product> findProductsByNameContaining(String name);

	@Query("SELECT p FROM Product p WHERE p.quantity <= ?1")
	List<Product> findLowStockProducts(Integer quantity);

	@Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
	List<Product> findProductsByPriceRange(Double minPrice, Double maxPrice);

	@Query("SELECT p FROM Product p ORDER BY p.price DESC")
	List<Product> findAllProductsOrderByPriceDesc();
}
