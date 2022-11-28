package com.example.choice_of_name.service;

import com.example.choice_of_name.model.Language;

import java.util.List;

public interface LanguageService {
    Language findLanguageById(Long id);
    List<Language> all();
}
