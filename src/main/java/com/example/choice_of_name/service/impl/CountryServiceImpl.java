package com.example.choice_of_name.service.impl;

import com.example.choice_of_name.model.Country;
import com.example.choice_of_name.repo.CountryRepo;
import com.example.choice_of_name.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepo countryRepo;

    public CountryServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }


    @Override
    public Country findCountryById(Long id) {
        return countryRepo.findCountryById(id);
    }

    @Override
    public List<Country> all() {
        return countryRepo.findAll();
    }
}
