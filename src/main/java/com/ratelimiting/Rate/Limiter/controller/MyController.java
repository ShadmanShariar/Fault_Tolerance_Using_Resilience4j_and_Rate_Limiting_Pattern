package com.ratelimiting.Rate.Limiter.controller;

import com.ratelimiting.Rate.Limiter.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/limited")
    public String limitedEndpoint() {
        return myService.processRequest();
    }
    public int tryCount = 0;
    @GetMapping("/limited2")
    public String limitedEndpoint2() {
        logger.info("tryCount: " + tryCount);
        tryCount++;
        return myService.processRequest2();
    }
}

