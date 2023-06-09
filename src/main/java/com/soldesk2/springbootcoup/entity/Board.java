package com.soldesk2.springbootcoup.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Board {

	public Board() {
	}
	
	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long index; //자동증가
	
	private String title;
	private String content;
	
	private String writer;
	
	@Column(insertable = false, updatable = false, columnDefinition = "datetime default now()")
	private Date date; //now()
	
	@Column(insertable = false, columnDefinition = "int default 0")
	private Long readCount;

	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL) // board와 연결, board의 변화가 모든 영향을 끼치도록 설정
	@JsonIgnoreProperties({"board"}) // Comment 객체를 JSON으로 변환할 때 Board 객체를 무시
	private List<Comment> comments = new ArrayList<>();

	public void addComment(Comment comment) {
		this.comments.add(comment);
		comment.setBoard(this);
	}
	@Override
    public String toString() {
        return "Board{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", date=" + date +
                ", readCount=" + readCount +
                ", comments=" + comments +
                '}';
    }
}
