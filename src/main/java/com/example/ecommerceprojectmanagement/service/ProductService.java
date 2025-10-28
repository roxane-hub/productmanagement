package com.example.ecommerceprojectmanagement.service;

import com.example.ecommerceprojectmanagement.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> findProductsByPriceGreaterThan(Double price);
    List<Product> findProductsByCategoryName(String categoryName);
    List<Product> findProductsByNameContaining(String name);
    List<Product> findLowStockProducts(Integer quantity);
    List<Product> findProductsByPriceRange(Double minPrice, Double maxPrice);
    List<Product> findAllProductsOrderByPriceDesc();
}
