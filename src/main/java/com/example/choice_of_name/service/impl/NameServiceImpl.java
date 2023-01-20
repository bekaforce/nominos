package com.example.choice_of_name.service.impl;

import com.example.choice_of_name.dto.NameDto;
import com.example.choice_of_name.model.Name;
import com.example.choice_of_name.repo.NameRepo;
import com.example.choice_of_name.service.NameService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public NameDto random(Long country, Long gender, Long language) {
        List<NameDto> names = searchNames(country, gender, language);
        if (names != null && !names.isEmpty()){
            Random random = new Random();
            int pos = random.nextInt(names.size());
            return names.get(pos);
        }
        return null;
    }

    @Override
    public boolean save(MultipartFile multipartFile) {
        try {
            String line;
            InputStreamReader inputStreamReader = new InputStreamReader(multipartFile.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(";");
                System.out.println(line);
            }
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<NameDto> searchNames(Long country, Long gender, Long language) {
        return nameRepo.searchAllByCountryGenderAndLanguage(country, gender, language);
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
