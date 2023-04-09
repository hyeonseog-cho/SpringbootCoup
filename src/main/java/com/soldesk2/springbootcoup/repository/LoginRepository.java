package com.soldesk2.springbootcoup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soldesk2.springbootcoup.entity.Member;

public interface LoginRepository extends JpaRepository<Member, String> {

}
