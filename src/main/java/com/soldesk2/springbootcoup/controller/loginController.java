package com.soldesk2.springbootcoup.controller;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soldesk2.springbootcoup.entity.Member;
import com.soldesk2.springbootcoup.entity.Role;
import com.soldesk2.springbootcoup.service.LoginService;

@RestController
public class loginController {

    @Autowired
    LoginService loginService;

    @MessageMapping("/login")
    @SendToUser("/login")
    public String login(@RequestBody Member message) {

        String id = message.getId();
        String password = message.getPassword();


        Boolean exist_user = loginService.get_user(id, password);

        if(exist_user == true){
            return id;
        } else{
            return "-1";
        }
    }

    @MessageMapping("/signup")
    @SendToUser("/signup")
    public String signup(@RequestBody Member message){
        
        Member member = new Member();
        member.setId(message.getId());
        member.setPassword(message.getPassword());
        member.setName(message.getName());
        member.setEmail(message.getEmail());
        member.setRole(Role.MEMBER);

        Member add_user = loginService.add_user(member);
        if (add_user == null) {
            return "-1";
        } else {
            return "1";
        }

    }
}
