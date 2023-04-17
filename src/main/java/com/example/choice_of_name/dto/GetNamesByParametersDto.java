package com.example.choice_of_name.dto;

import lombok.Data;

@Data
public class GetNamesByParametersDto {
    private Long genderId;
    private Long languageId;
    private Long countryId;
}
