package com.mainframe.mainframe.member.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberResponseDto {
    private Long memberId;
    private String email;
    private String name;
    private String role;
}
