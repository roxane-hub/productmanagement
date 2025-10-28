package com.example.ecommerceprojectmanagement.repository;

import com.example.ecommerceprojectmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Long countProductsByCategoryId(Long categoryId);

    List<Category> findByNameContaining(String name);

    Optional<Category> findByName(String name);
}
