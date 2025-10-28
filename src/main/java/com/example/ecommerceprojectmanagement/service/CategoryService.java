package com.example.ecommerceprojectmanagement.service;

import com.example.ecommerceprojectmanagement.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category saveCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
    Optional<Category> findByName(String name);
    List<Category> findByNameContaining(String name);
    Long countProductsByCategoryId(Long categoryId);
}

