package com.example.choice_of_name.service.impl;

import com.example.choice_of_name.model.Gender;
import com.example.choice_of_name.repo.GenderRepo;
import com.example.choice_of_name.service.GenderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {
    private final GenderRepo genderRepo;

    public GenderServiceImpl(GenderRepo genderRepo) {
        this.genderRepo = genderRepo;
    }

    @Override
    public Gender findGenderById(Long id) {
        return genderRepo.findGenderById(id);
    }

    @Override
    public List<Gender> all() {
        return genderRepo.findAll();
    }
}
