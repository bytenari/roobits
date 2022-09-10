package com.mainframe.mainframe.member.dto;

import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
public class MemberPostDto {
    private String password;
    @Email
    private String email;
    private String name;
    private String role;
}
