package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RestController 
@RequestMapping ("api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping ("category")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping ("category/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @PostMapping ("category/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping ("category/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping ("category/{id}")
    public Boolean deleteCategory(@PathVariable int id) {
        return categoryService.delete(id);
    }
}
