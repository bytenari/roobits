package com.mainframe.mainframe.roobit.dto;

import lombok.Getter;

@Getter
public class RoobitDto {
    private Long roobitId;
    private String password;
    private String content;

    //검색필터
    private String keyword;
}
