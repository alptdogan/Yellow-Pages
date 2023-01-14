package com.alpdogan.YellowPages.service;

import com.alpdogan.YellowPages.entity.Firm;
import com.alpdogan.YellowPages.dto.requestDto.SaveFirmRequestDto;
import com.alpdogan.YellowPages.repository.FirmRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FirmServiceTest {

    @InjectMocks
    FirmService firmService;

    @Mock
    FirmRepository firmRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void testFindFirmById() {

        Firm firmMock = mock(Firm.class);
        firmMock.setId(1);

        when(firmRepository.findById(firmMock.getId())).thenReturn(Optional.of(firmMock));
        Firm findFirm = firmService.findFirmById(firmMock.getId());

        assertEquals(firmMock, findFirm);

    }

    @Test
    void testSaveFirm() {

        SaveFirmRequestDto saveFirmRequestDtoMock = mock(SaveFirmRequestDto.class);
        saveFirmRequestDtoMock.setFirmName("Forbes");

        Firm firmMock = mock(Firm.class);
        firmMock.setId(1);

        when(modelMapper.map(saveFirmRequestDtoMock, Firm.class)).thenReturn(firmMock);
        when(firmRepository.save(firmMock)).thenReturn(firmMock);

        String saveFirm = firmService.saveFirm(saveFirmRequestDtoMock);
        String saveFirmMessage = firmMock.getFirmName() + " has been created successfully.";

        assertEquals(saveFirmMessage, saveFirm);

    }

}
