package com.mainframe.mainframe.board.dto;

import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class BoardPostDto {
    private String boardName;

    private Date dDay;

    private long boardTheme;

    private String boardStatus;

    private LocalDateTime createdAt;
}
