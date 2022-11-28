package com.example.choice_of_name.repo;

import com.example.choice_of_name.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findCategoryById(Long id);
}
