package com.example.choice_of_name.repo;

import com.example.choice_of_name.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
    Country findCountryById(Long id);
}
