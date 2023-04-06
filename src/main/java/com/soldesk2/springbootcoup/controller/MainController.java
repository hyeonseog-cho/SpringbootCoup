package com.soldesk2.springbootcoup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @GetMapping({"/","/index"})
    public String index() {
        return "2Team Java Spring boot BoardGame_Coup!!!";
    }
}
