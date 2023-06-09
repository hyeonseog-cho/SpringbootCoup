package com.soldesk2.springbootcoup.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

    @Override
    public int wincountup(String id) {
        System.out.println("메서드실행됨");
        Optional<Member> finduser = loginRepository.findById(id);
        Member updateuser = finduser.get();
        updateuser.setWincount(updateuser.getWincount() + 1);
        loginRepository.save(updateuser);

        return updateuser.getWincount();
    }

    @Override
    public List<Member> rank() {
        List<Member> members = loginRepository.findAll();

        Collections.sort(members, new Comparator<Member>() {

            @Override
            public int compare(Member m1, Member m2) {
                return m2.getWincount() - m1.getWincount();
            }
            
        });
        
        if (members.size() < 5) {
            return members;
        } else{
            return members.subList(0, 5);
        }
    }

}


