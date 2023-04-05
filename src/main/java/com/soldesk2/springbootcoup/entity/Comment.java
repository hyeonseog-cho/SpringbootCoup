package com.soldesk2.springbootcoup.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Comment {

    public Comment() {
    }

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String content;
    private String writer;

    @Column(insertable = false, updatable = false, columnDefinition = "datetime default now()")
	private Date date; //now()

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "index")
    private Board board;

    @Override
    public String toString() {
    return "Comment{" +
            "idx=" + idx +
            ", content='" + content + '\'' +
            ", writer='" + writer + '\'' +
            '}';
    }
}
