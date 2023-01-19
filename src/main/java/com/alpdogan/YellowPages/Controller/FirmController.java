package com.alpdogan.YellowPages.Controller;

import com.alpdogan.YellowPages.dto.requestDto.SaveFirmRequestDto;
import com.alpdogan.YellowPages.dto.requestDto.UpdateFirmRequestDto;
import com.alpdogan.YellowPages.dto.responseDto.FirmResponseDto;
import com.alpdogan.YellowPages.entity.Firm;
import com.alpdogan.YellowPages.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firm")
public class FirmController {

    @Autowired
    FirmService firmService;

    @PostMapping("/saveFirm")
    public ResponseEntity<String> saveFirm(@RequestBody SaveFirmRequestDto saveFirmRequestDto) {

        String firmSaveDescription = firmService.saveFirm(saveFirmRequestDto);

        return new ResponseEntity<>(firmSaveDescription, HttpStatus.OK);

    }

    @GetMapping("/findFirmById")
    public ResponseEntity<Firm> findFirmById(@RequestParam Integer firmId) {

        Firm firm = firmService.findFirmById(firmId);

        return new ResponseEntity<>(firm, HttpStatus.OK);

    }

    @GetMapping("findAllFirms")
    public ResponseEntity<List<FirmResponseDto>> findAllFirms() {

        List<FirmResponseDto> firmResponseDtos = firmService.findAllFirms();

        return new ResponseEntity<>(firmResponseDtos, HttpStatus.OK);

    }

    @PostMapping("/updateFirm")
    public ResponseEntity<String> updateFirm(@RequestBody UpdateFirmRequestDto updateFirmRequestDto) {

        String updateFirmDescription = firmService.updateFirm(updateFirmRequestDto);

        return new ResponseEntity<>(updateFirmDescription, HttpStatus.OK);

    }

    @DeleteMapping("/deleteFirm")
    public ResponseEntity<String> deleteFirmById(@RequestParam Integer firmId) {

        String deleteFirmDescription = firmService.deleteFirmById(firmId);

        return new ResponseEntity<>(deleteFirmDescription, HttpStatus.OK);

    }

}
