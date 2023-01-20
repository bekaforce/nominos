package com.example.choice_of_name.controller;

import com.example.choice_of_name.model.Country;
import com.example.choice_of_name.service.impl.CountryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Url.COUNTRY)
public class CountryController {
    private final CountryServiceImpl countryService;

    public CountryController(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    @GetMapping(Url.ALL)
    public ResponseEntity<?> all(){
        List<Country> response = countryService.all();
        return response != null && !response.isEmpty()
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }
}