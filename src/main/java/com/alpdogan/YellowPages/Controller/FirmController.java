package com.alpdogan.YellowPages.Controller;

import com.alpdogan.YellowPages.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firm")
public class FirmController {

    @Autowired
    FirmService firmService;

}
