package com.example.choice_of_name.service;

import com.example.choice_of_name.model.Category;

import java.util.List;

public interface CategoryService {
    Category findCategoryById(Long id);
    List<Category> all();
}
