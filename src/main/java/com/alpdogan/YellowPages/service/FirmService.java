package com.alpdogan.YellowPages.service;

import com.alpdogan.YellowPages.dto.requestDto.UpdateFirmRequestDto;
import com.alpdogan.YellowPages.dto.responseDto.FirmResponseDto;
import com.alpdogan.YellowPages.entity.Firm;
import com.alpdogan.YellowPages.dto.requestDto.SaveFirmRequestDto;
import com.alpdogan.YellowPages.repository.FirmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FirmService {

    @Autowired
    FirmRepository firmRepository;

    @Autowired
    ModelMapper modelMapper;


    public Firm findFirmById(int firmId) {

        return firmRepository.findById(firmId).get();

    }

    public List<FirmResponseDto> findAllFirms() {

        Iterable<Firm> firms = firmRepository.findAll();

        List<FirmResponseDto> firmResponseDtos = new ArrayList<>();

        for (Firm firm : firms) {
            FirmResponseDto firmResponseDto = modelMapper.map(firm, FirmResponseDto.class);
            firmResponseDtos.add(firmResponseDto);
        }

        return firmResponseDtos;

    }

    public String saveFirm(SaveFirmRequestDto saveFirmRequestDto) {

        Firm firm = modelMapper.map(saveFirmRequestDto, Firm.class);

        firm = firmRepository.save(firm);

        return firm.getFirmName() + " has been created successfully.";

    }

    public String updateFirm(UpdateFirmRequestDto updateFirmRequestDto) {

        int firmIdRequest = updateFirmRequestDto.getId();
        String firmNameRequest = updateFirmRequestDto.getFirmName();

        Optional<Firm> firmOptional = firmRepository.findById(firmIdRequest);
        Firm firm = firmOptional.get();

        firm.setFirmName(firmNameRequest);

        firmRepository.save(firm);

        return "Changes saved successfully.";

    }

    public String deleteFirmById(Integer firmId) {

        Optional<Firm> firmOptional = firmRepository.findById(firmId);
        Firm firm = firmOptional.get();
        firmRepository.delete(firm);

        return "The firm has been deleted.";

    }

}
