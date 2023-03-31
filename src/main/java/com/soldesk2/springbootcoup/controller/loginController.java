package com.soldesk2.springbootcoup.controller;

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
    public String login(@RequestBody Member message) {

        String id = message.getId();
        String password = message.getPassword();

        Boolean exist_user = loginService.get_user(id, password);

        if(exist_user == false || exist_user == null){
            return "-1";
        } else{
            return "1";
        }
    }

    @PostMapping("/signup")
    public String signup(@RequestBody Member message){
        
        Member member = new Member();
        member.setId(message.getId());
        member.setPassword(message.getPassword());
        member.setName(message.getName());
        member.setEmail(message.getEmail());

        Member add_user = loginService.add_user(member);
        if (add_user == null) {
            return "-1";
        } else {
            return "1";
        }

    }
}
