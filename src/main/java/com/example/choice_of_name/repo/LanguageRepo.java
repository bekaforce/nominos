package com.example.choice_of_name.repo;

import com.example.choice_of_name.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Long> {
    Language findLanguageById(Long id);
}
