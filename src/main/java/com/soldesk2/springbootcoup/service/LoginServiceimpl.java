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
    public String get_user(Member user) {
        Optional<Member> finduser = loginRepository.findById(user.getId());
        loginRepository.save(user);
    
        if(!finduser.isPresent() || finduser == null){
            return "-1";    
        } else{
            if (finduser.get().getPassword().equals(user.getPassword())){
                return "1";
            }
            return "-2";
        }
    }

}
