package com.soldesk2.springbootcoup.service;

import java.util.List;

import com.soldesk2.springbootcoup.entity.Member;

public interface LoginService {

    public String login(Member user); // 로그인 유효성 검사

    public String signUp(Member user); // 회원 가입

    public int wincountup(String id);    // 유저의 승리횟수 증가

    public List<Member> rank(); // 승리횟수로 정렬한 멤버 리스트

}
