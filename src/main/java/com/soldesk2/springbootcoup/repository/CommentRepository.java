package com.soldesk2.springbootcoup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soldesk2.springbootcoup.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
