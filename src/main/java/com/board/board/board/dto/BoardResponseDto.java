package com.mainframe.mainframe.board.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class BoardResponseDto {
    private long boardId;

    private String boardName;

    private long restDay;

    private long boardTheme;
    
    private String boardStatus;

    private LocalDateTime createdAt;

    public BoardResponseDto(long boardId, String boardName, long boardTheme, String boardStatus, LocalDateTime createdAt, long restDay) {
    }
}
