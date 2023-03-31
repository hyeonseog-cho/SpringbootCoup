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
        
        
    
        if(!finduser.isPresent()) {
            loginRepository.save(user);
            return "-1";  // 새로 생성한 id
        } else {
            System.out.println(finduser.get().getPassword());
            System.out.println(user.getPassword());
            if (finduser.get().getPassword().equals(user.getPassword())) {
                return "1"; // 기존 id / db pw와 입력 pw가 같을 때
            }
            return "-2"; // 기존 id / pw 다를 때
        }
    }

}
