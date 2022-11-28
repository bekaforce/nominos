package com.example.choice_of_name.service;

import com.example.choice_of_name.model.Gender;

import java.util.List;

public interface GenderService {
    Gender findGenderById(Long id);
    List<Gender> all();
}
