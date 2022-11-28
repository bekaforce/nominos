package com.example.choice_of_name.repo;

import com.example.choice_of_name.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepo extends JpaRepository<Gender, Long> {
    Gender findGenderById(Long id);
}
