package com.soldesk2.springbootcoup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    private String id;
    private String password;
    private String nickname;
    private int wincount;
}
