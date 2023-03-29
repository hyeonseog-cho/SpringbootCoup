package com.soldesk2.springbootcoup.service;

import com.soldesk2.springbootcoup.entity.Member;

public interface LoginService { 
    public Member add_user(Member user);                       // 유저 추가
    public Boolean get_user(String id, String password);   // 해당 id값이 있는지 검색
}
