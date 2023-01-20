package com.example.choice_of_name.service;

import com.example.choice_of_name.model.Country;

import java.util.List;

public interface CountryService {
    Country findCountryById(Long id);
    List<Country> all();
}
