package com.example.choice_of_name.controller;

import com.example.choice_of_name.dto.GetNamesByParametersDto;
import com.example.choice_of_name.dto.NameDto;
import com.example.choice_of_name.service.impl.NameServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
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

    @PostMapping("/namesByParameters")
    public ResponseEntity<?> findNames(@RequestBody GetNamesByParametersDto getNamesByParametersDto){
        List<NameDto> response = nameService.searchNames(getNamesByParametersDto.getCountryId(), getNamesByParametersDto.getGenderId(), getNamesByParametersDto.getLanguageId());
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

    @PostMapping("/random")
    public ResponseEntity<?> random(@RequestBody GetNamesByParametersDto getNamesByParametersDto){
        NameDto response = nameService.random(getNamesByParametersDto.getCountryId(), getNamesByParametersDto.getGenderId(), getNamesByParametersDto.getGenderId());
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
