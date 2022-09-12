package com.mainframe.mainframe.board.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class BoardPutDto {
    private long boardId;

    private String boardName;

    private Date dDay;

    private long boardTheme;

    private String boardStatus;

    private LocalDateTime createdAt;
}
