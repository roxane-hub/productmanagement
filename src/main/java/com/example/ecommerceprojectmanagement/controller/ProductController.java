package com.example.ecommerceprojectmanagement.controller;

import com.example.ecommerceprojectmanagement.model.Product;
import com.example.ecommerceprojectmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/price-greater-than/{price}")
    public ResponseEntity<List<Product>> getProductsByPriceGreaterThan(@PathVariable Double price) {
        List<Product> products = productService.findProductsByPriceGreaterThan(price);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Product>> getProductsByCategoryName(@PathVariable String categoryName) {
        List<Product> products = productService.findProductsByCategoryName(categoryName);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
        List<Product> products = productService.findProductsByNameContaining(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/low-stock/{quantity}")
    public ResponseEntity<List<Product>> getLowStockProducts(@PathVariable Integer quantity) {
        List<Product> products = productService.findLowStockProducts(quantity);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getProductsByPriceRange(
            @RequestParam Double minPrice, 
            @RequestParam Double maxPrice) {
        List<Product> products = productService.findProductsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/sorted-by-price")
    public ResponseEntity<List<Product>> getAllProductsSortedByPrice() {
        List<Product> products = productService.findAllProductsOrderByPriceDesc();
        return ResponseEntity.ok(products);
    }
}
