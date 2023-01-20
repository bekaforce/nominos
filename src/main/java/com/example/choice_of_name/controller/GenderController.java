package com.example.choice_of_name.controller;

import com.example.choice_of_name.model.Gender;
import com.example.choice_of_name.service.impl.GenderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(Url.GENDER)
public class GenderController {
    private final GenderServiceImpl genderService;

    public GenderController(GenderServiceImpl genderService) {
        this.genderService = genderService;
    }

    @GetMapping(Url.ALL)
    public ResponseEntity<?> all(){
        List<Gender> response = genderService.all();
        return response != null && !response.isEmpty()
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }
}
