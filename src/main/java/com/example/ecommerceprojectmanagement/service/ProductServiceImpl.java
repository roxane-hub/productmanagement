package com.example.ecommerceprojectmanagement.service;

import com.example.ecommerceprojectmanagement.model.Product;
import com.example.ecommerceprojectmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                    product.setQuantity(updatedProduct.getQuantity());
                    product.setCategory(updatedProduct.getCategory());
                    return productRepository.save(product);
                }).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findProductsByPriceGreaterThan(Double price) {
        return productRepository.findProductsByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findProductsByCategoryName(String categoryName) {
        return productRepository.findProductsByCategoryName(categoryName);
    }

    @Override
    public List<Product> findProductsByNameContaining(String name) {
        return productRepository.findProductsByNameContaining(name);
    }

    @Override
    public List<Product> findLowStockProducts(Integer quantity) {
        return productRepository.findLowStockProducts(quantity);
    }

    @Override
    public List<Product> findProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findProductsByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Product> findAllProductsOrderByPriceDesc() {
        return productRepository.findAllProductsOrderByPriceDesc();
    }
}
