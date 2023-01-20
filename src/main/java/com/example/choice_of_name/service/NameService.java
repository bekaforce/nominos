package com.example.choice_of_name.service;

import com.example.choice_of_name.dto.NameDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NameService {
    List<NameDto> searchNames(Long country, Long gender, Long language);
    String descriptionById(Long id);
    List<NameDto> allByLanguage(Long language_id);
    NameDto random(Long country, Long gender, Long language);
    boolean save(MultipartFile multipartFile);
}
