package com.soldesk2.springbootcoup.entity;

import java.util.Date;

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
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String writer;

    @Column(insertable = false, updatable = false, columnDefinition = "datetime default now()")
	private Date date; //now()

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "index")
    private Board board;
}
