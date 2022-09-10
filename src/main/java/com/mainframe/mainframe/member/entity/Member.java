package com.mainframe.mainframe.member.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@NoArgsConstructor
@Entity
@Data // getter, setter 역할
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 10, nullable = false)
    private String password;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @Column(length = 10, nullable = false)
    private String name;

    @Column
    private String role;

    public Member(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
