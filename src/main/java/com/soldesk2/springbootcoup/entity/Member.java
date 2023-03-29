package com.soldesk2.springbootcoup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "COUP_USER")
public class Member {
    @Id
    private String id;
    private String password;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
}
