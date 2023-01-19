package com.alpdogan.YellowPages.dto.requestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SaveJobRequestDto {

    private String title;
    private int firmId;
    private int categoryId;
    private String description;
    private LocalDate publicationDate;

}
