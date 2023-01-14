package comalpdogan.YellowPages.service;

import comalpdogan.YellowPages.entity.Firm;
import comalpdogan.YellowPages.repository.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirmService {

    @Autowired
    FirmRepository firmRepository;


    public Firm findFirmById(int firmId) {

        return firmRepository.findById(firmId).get();

    }
}
