package com.mainframe.mainframe.roobit.dto;

import lombok.Getter;

@Getter
public class RoobitPutDto {
    private Long roobitId;
    private String password;
    private String content;

    public void setRoobitId(Long roobitId) {
        this.roobitId = roobitId;
    }
}
