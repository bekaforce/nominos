package com.example.choice_of_name.controller;

import com.example.choice_of_name.dto.NameDto;
import com.example.choice_of_name.dto.SearchDto;
import com.example.choice_of_name.model.Name;
import com.example.choice_of_name.service.impl.NameServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( Url.NAME)
public class NameController {
    private final NameServiceImpl nameService;

    public NameController(NameServiceImpl nameService) {
        this.nameService = nameService;
    }

    @GetMapping(Url.ALL + Url.LANGUAGE_ID)
    public ResponseEntity<?> allByLanguage(@PathVariable(value = "language_id") Long language_id){
        List<NameDto> response = nameService.allByLanguage(language_id);
        return response != null && !response.isEmpty()
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/namesByParameters/{category_id}/{gender_id}/{language_id}")
    public ResponseEntity<?> findNames(@PathVariable(value = "category_id") Long category_id, @PathVariable(value = "gender_id") Long gender_id, @PathVariable(value = "language_id") Long language_id){
        List<NameDto> response = nameService.searchNames(category_id, gender_id, language_id);
        return response != null && !response.isEmpty()
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/descriptionById/{name_id}")
    public ResponseEntity<?> findDescriptionByNameId(@PathVariable(value = "name_id") Long name_id){
        String response = nameService.descriptionById(name_id);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/random/{category_id}/{gender_id}/{language_id}")
    public ResponseEntity<?> random(@PathVariable(value = "category_id") Long category_id, @PathVariable(value = "gender_id") Long gender_id, @PathVariable(value = "language_id") Long language_id){
        NameDto response = nameService.random(category_id, gender_id, language_id);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }
}
