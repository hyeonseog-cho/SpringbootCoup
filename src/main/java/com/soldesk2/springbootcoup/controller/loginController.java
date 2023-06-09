package com.soldesk2.springbootcoup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soldesk2.springbootcoup.entity.Member;
import com.soldesk2.springbootcoup.service.LoginService;

@RestController
public class loginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody Member user) {
        return loginService.login(user);
    }

    @PostMapping("/signUp")
    public String signUp(@RequestBody Member user) {
        return loginService.signUp(user);
    }

    @GetMapping("/rank")
    public List<Member> rank() {
        List<Member> members = loginService.rank();

        return members;  
    }

}
