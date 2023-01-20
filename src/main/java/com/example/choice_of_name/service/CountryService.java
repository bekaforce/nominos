package com.example.choice_of_name.service;

import com.example.choice_of_name.model.Country;

import java.util.List;

public interface CategoryService {
    Country findCategoryById(Long id);
    List<Country> all();
}
