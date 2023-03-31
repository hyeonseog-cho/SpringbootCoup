package com.soldesk2.springbootcoup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk2.springbootcoup.entity.Member;
import com.soldesk2.springbootcoup.repository.LoginRepository;

@Service
public class LoginServiceimpl implements LoginService{

    @Autowired
    LoginRepository loginRepository;

    @Override
    public String get_user(String id, String password, String name) {
        Optional<Member> user = loginRepository.findById(id);

        if(!user.isPresent() || user == null){
            return "-1";    
        } else{
            if (user.get().getPassword().equals(password)){
                return "1";
            }
            return "-2";
        }
    }

}
