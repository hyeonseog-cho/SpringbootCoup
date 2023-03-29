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
    public Member add_user(Member user){
        Optional<Member> member = loginRepository.findById(user.getId());
        if(member.isPresent()){
            return null;
        }
        Member new_user = loginRepository.save(user);
        return new_user;
    }

    @Override
    public Boolean get_user(String id, String password) {
        Optional<Member> user = loginRepository.findById(id);
        if(user == null || !user.get().getPassword().equals(password)){
            return false;
        }
        return true;
    }

}
