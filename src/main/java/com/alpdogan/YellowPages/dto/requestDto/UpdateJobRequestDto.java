package com.alpdogan.YellowPages.dto.requestDto;

import lombok.Data;

@Data
public class UpdateJobRequestDto {

    private int id;
    private String title;
    private int firmId;
    private int categoryId;

}
