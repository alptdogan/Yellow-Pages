package com.alpdogan.YellowPages.Controller;

import com.alpdogan.YellowPages.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

}
