package com.soldesk2.springbootcoup.service;

import com.soldesk2.springbootcoup.entity.Member;

public interface LoginService { 

    public String get_user(Member user);   // 회원 가입 / 로그인 유효성 검사
    public void wincountup(String id); // 유저의 승리횟수 증가
}
