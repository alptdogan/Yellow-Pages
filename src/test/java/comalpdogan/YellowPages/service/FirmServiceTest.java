package comalpdogan.YellowPages.service;

import comalpdogan.YellowPages.entity.Firm;
import comalpdogan.YellowPages.repository.FirmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FirmServiceTest {

    @Autowired
    FirmService firmService;

    @MockBean
    FirmRepository firmRepository;

    @Test
    void testFindFirmById() {

        Firm firmMock = mock(Firm.class);
        firmMock.setId(1);

        when(firmRepository.findById(firmMock.getId())).thenReturn(Optional.of(firmMock));
        Firm findFirm = firmService.findFirmById(firmMock.getId());

        assertEquals(firmMock, findFirm);

    }



}
