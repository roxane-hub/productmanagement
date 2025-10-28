package com.example.ecommerceprojectmanagement.config;

import com.example.ecommerceprojectmanagement.model.Category;
import com.example.ecommerceprojectmanagement.model.Product;
import com.example.ecommerceprojectmanagement.repository.CategoryRepository;
import com.example.ecommerceprojectmanagement.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataInitializer(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category electronics = new Category("Electronics");
        Category clothing = new Category("Clothing");
        Category books = new Category("Books");
        Category home = new Category("Home & Garden");

        categoryRepository.save(electronics);
        categoryRepository.save(clothing);
        categoryRepository.save(books);
        categoryRepository.save(home);

        Product laptop = new Product("Laptop", 999.99, 10, electronics);
        Product smartphone = new Product("Smartphone", 699.99, 25, electronics);
        Product tshirt = new Product("T-Shirt", 19.99, 50, clothing);
        Product chair = new Product("Office Chair", 199.99, 5, home);

        productRepository.save(laptop);
        productRepository.save(smartphone);
        productRepository.save(tshirt);
        productRepository.save(chair);

        System.out.println("Sample data initialized successfully!");
    }
}

