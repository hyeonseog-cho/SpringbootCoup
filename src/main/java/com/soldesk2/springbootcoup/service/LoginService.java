package com.soldesk2.springbootcoup.service;

import com.soldesk2.springbootcoup.entity.Member;

public interface LoginService {

    public String login(Member user); // 로그인 유효성 검사

    public String signUp(Member user); // 회원 가입

}
