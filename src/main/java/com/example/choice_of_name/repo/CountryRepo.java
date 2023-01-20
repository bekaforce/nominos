package com.example.choice_of_name.repo;

import com.example.choice_of_name.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Country, Long> {
    Country findCategoryById(Long id);
}
