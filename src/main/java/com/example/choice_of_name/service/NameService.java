package com.example.choice_of_name.service;

import com.example.choice_of_name.dto.NameDto;
import com.example.choice_of_name.model.Name;

import java.util.List;

public interface NameService {
    List<NameDto> searchNames(Long category_id, Long gender_id, Long language_id);
    String descriptionById(Long id);
    List<NameDto> allByLanguage(Long language_id);
    NameDto random(Long category_id, Long gender_id, Long language_id);
}
