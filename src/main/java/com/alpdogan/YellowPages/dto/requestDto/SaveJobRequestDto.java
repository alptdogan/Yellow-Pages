package com.alpdogan.YellowPages.dto.requestDto;

import lombok.Data;

@Data
public class SaveJobRequestDto {

    private String title;
    private int firmId;
    private int categoryId;

}
