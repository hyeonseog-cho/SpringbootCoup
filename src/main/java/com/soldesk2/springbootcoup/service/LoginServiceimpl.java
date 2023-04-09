package com.soldesk2.springbootcoup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soldesk2.springbootcoup.entity.Member;
import com.soldesk2.springbootcoup.repository.LoginRepository;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public String login(Member user) {
        Optional<Member> finduser = loginRepository.findById(user.getId());

        if (!finduser.isPresent()) {
            return "-1"; // 사용자가 존재하지 않음
        } else {
            System.out.println(
                    finduser.get().getId() + "," + finduser.get().getPassword() + "," + finduser.get().getNickname());
            System.out.println(user.getId() + "," + user.getPassword() + "," + user.getNickname());
            if (finduser.get().getPassword().equals(user.getPassword())) {
                return "1," + finduser.get().getId() + "," + finduser.get().getNickname();
                // return "1"; // 기존 id / db pw와 입력 pw가 같을 때
            }
            return "-2"; // 기존 id / pw 다를 때
        }
    }

    @Override
    public String signUp(Member user) {
        Optional<Member> finduser = loginRepository.findById(user.getId());

        if (!finduser.isPresent()) {
            loginRepository.save(user);
            return "-3"; // 회원 가입 성공
        } else {
            return "-4"; // 이미 존재하는 아이디
        }
    }
}
