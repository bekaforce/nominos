package com.example.choice_of_name.service.impl;

import com.example.choice_of_name.model.Language;
import com.example.choice_of_name.repo.LanguageRepo;
import com.example.choice_of_name.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepo languageRepo;

    public LanguageServiceImpl(LanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }

    @Override
    public Language findLanguageById(Long id) {
        return  languageRepo.findLanguageById(id);
    }

    @Override
    public List<Language> all() {
        return languageRepo.findAll();
    }
}
