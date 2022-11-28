package com.example.choice_of_name.service.impl;

import com.example.choice_of_name.dto.NameDto;
import com.example.choice_of_name.model.Name;
import com.example.choice_of_name.repo.NameRepo;
import com.example.choice_of_name.service.NameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class NameServiceImpl implements NameService {
    private final NameRepo nameRepo;

    public NameServiceImpl(NameRepo nameRepo) {
        this.nameRepo = nameRepo;
    }

    public List<NameDto> allByLanguage(Long language_id){
        return nameRepo.findAllByLanguageAndOrderByTitle(language_id);
    }

    @Override
    public NameDto random(Long category_id, Long gender_id, Long language_id) {
        List<NameDto> names = searchNames(category_id, gender_id, language_id);
        if (names != null && !names.isEmpty()){
            Random random = new Random();
            int pos = random.nextInt(names.size());
            return names.get(pos);
        }
        return null;
    }

    @Override
    public List<NameDto> searchNames(Long category_id, Long gender_id, Long language_id) {
        return nameRepo.searchAllByCategoryGenderAndLanguage(category_id, gender_id, language_id);
    }

    @Override
    public String descriptionById(Long id) {
        Name name = nameRepo.findNameById(id);
        if (name != null){
            return name.getDescription();
        }
        return "";
    }
}
