package com.example.choice_of_name.controller;

import com.example.choice_of_name.model.Language;
import com.example.choice_of_name.model.Name;
import com.example.choice_of_name.service.impl.LanguageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Url.LANGUAGE)
public class LanguageController {
 private final LanguageServiceImpl languageService;

    public LanguageController(LanguageServiceImpl languageService) {
        this.languageService = languageService;
    }

    @GetMapping(Url.ALL)
    public ResponseEntity<?> all(){
        List<Language> response = languageService.all();
        return response != null && !response.isEmpty()
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }
}
