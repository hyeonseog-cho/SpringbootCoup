package com.soldesk2.springbootcoup.service;

import com.soldesk2.springbootcoup.entity.Member;

public interface LoginService { 

    public String get_user(Member user);   // 해당 id값이 있는지 검색
    
}
