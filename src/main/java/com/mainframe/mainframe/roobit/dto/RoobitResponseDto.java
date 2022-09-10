package com.mainframe.mainframe.roobit.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RoobitResponseDto {
    private Long roobitId;
    private String content;
}
