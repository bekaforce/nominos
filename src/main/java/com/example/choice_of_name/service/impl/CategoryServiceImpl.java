package com.example.choice_of_name.service.impl;

import com.example.choice_of_name.model.Category;
import com.example.choice_of_name.repo.CategoryRepo;
import com.example.choice_of_name.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepo.findCategoryById(id);
    }

    @Override
    public List<Category> all() {
        return categoryRepo.findAll();
    }
}
