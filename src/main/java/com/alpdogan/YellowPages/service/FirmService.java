package com.alpdogan.YellowPages.service;

import com.alpdogan.YellowPages.dto.requestDto.UpdateFirmRequestDto;
import com.alpdogan.YellowPages.entity.Firm;
import com.alpdogan.YellowPages.dto.requestDto.SaveFirmRequestDto;
import com.alpdogan.YellowPages.repository.FirmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String saveFirm(SaveFirmRequestDto saveFirmRequestDto) {

        Firm firm = modelMapper.map(saveFirmRequestDto, Firm.class);

        firm = firmRepository.save(firm);

        return firm.getFirmName() + " has been created successfully.";

    }

    public String updateFirm(UpdateFirmRequestDto updateFirmRequestDto)
    {
        int firmIdRequest = updateFirmRequestDto.getId();
        String firmNameRequest = updateFirmRequestDto.getFirmName();

        Optional<Firm> firmOptional = firmRepository.findById(firmIdRequest);
        Firm firm = firmOptional.get();

        firm.setFirmName(firmNameRequest);

        firmRepository.save(firm);

        return "Changes saved successfully.";
    }

}
