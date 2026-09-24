package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service 
public class CategoryService {
    @Autowired 
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategory();
    }

    public Category getCategory(int id) {
        return categoryRepository.findById(id).get();
    }

    @Transactional 
    public Category save(Category category) {
        category.setCreatedAt(LocalDate.now());
        return categoryRepository.save(category);
    }

    public Category update(int id, Category category) {
        Category current = categoryRepository.findById(id).get();
        current.setName(category.getName());

        return categoryRepository.save(current);
    }

    public Boolean delete(int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
