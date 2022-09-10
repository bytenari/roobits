package com.mainframe.mainframe.member.dto;

import lombok.Getter;

@Getter
public class MemberPutDto {
    private Long memberId;
    private String password;
    private String name;
    private String role;
}
