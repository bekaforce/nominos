package com.example.choice_of_name.controller;

import com.example.choice_of_name.dto.NameDto;
import com.example.choice_of_name.service.impl.NameServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/namesByParameters/{country_id}/{gender_id}/{language_id}")
    public ResponseEntity<?> findNames(@PathVariable(value = "country_id") Long country, @PathVariable(value = "gender_id") Long gender, @PathVariable(value = "language_id") Long language){
        List<NameDto> response = nameService.searchNames(country, gender, language);
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

    @GetMapping("/random/{country_id}/{gender_id}/{language_id}")
    public ResponseEntity<?> random(@PathVariable(value = "country_id") Long country, @PathVariable(value = "gender_id") Long gender, @PathVariable(value = "language_id") Long language){
        NameDto response = nameService.random(country, gender, language);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }


    @PostMapping("/name")
    public ResponseEntity<?> name(@RequestParam("multipartFile") MultipartFile multipartFile){
        boolean response = nameService.save(multipartFile);
        return response
                ? new ResponseEntity<>(true, HttpStatus.OK)
                : new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
    }
}
