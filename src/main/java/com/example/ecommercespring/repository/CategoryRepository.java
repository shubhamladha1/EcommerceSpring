package com.example.ecommercespring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecommercespring.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
