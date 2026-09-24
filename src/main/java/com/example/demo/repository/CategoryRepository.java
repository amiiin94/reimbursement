package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;

@Repository 
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    @Query (
        """
                SELECT new com.example.demo.model.Category (
                id,
                name,
                createdAt,
                createdBy
                ) 
                FROM Category
        """
    )

    public List<Category> getAllCategory();

    
}
