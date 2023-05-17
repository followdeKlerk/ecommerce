package com.nathan.ecommerce.service;

import com.nathan.ecommerce.entity.Category;
import com.nathan.ecommerce.exceptions.InvalidInputException;
import com.nathan.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public void createCategory(Category category) {
        if (category.getImageUrl() == null || category.getImageUrl().isEmpty()) {
            throw new InvalidInputException("Image URL cannot be null or empty");
        }
        categoryRepository.save(category);
    }

    public Category readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public Optional<Category> readCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public void updateCategory(Integer categoryId, Category category) {
        Category category1 = categoryRepository.findById(categoryId).get();
        category.setCategoryName(category1.getCategoryName());
        category.setDescription(category1.getDescription());
        category.setImageUrl(category1.getImageUrl());
        categoryRepository.save(category);
    }
}
