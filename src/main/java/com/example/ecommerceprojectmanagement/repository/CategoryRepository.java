package com.example.ecommerceprojectmanagement.repository;

import com.example.productmanagementsystem1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
