package com.mainframe.mainframe.board.mapper;

import com.mainframe.mainframe.board.dto.BoardPostDto;
import com.mainframe.mainframe.board.dto.BoardPutDto;
import com.mainframe.mainframe.board.dto.BoardResponseDto;
import com.mainframe.mainframe.board.entity.Board;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface BoardMapper {
    Board boardPostDtoToBoard(BoardPostDto boardPostDto);
    Board boardPutDtoToBoard(BoardPutDto boardPutDto);
    default BoardResponseDto boardToBoardResponseDto(Board board) {
        Date currentDate = new Date (System.currentTimeMillis());
        Date dDay = board.getDDay();
        long restDay = (dDay.getTime() - currentDate.getTime())/(1000*24*60*60) + 1;

        BoardResponseDto boardResponseDto = new BoardResponseDto(
                board.getBoardId(),
                board.getBoardName(),
                board.getBoardTheme(),
                board.getBoardStatus(),
                board.getCreatedAt(),
                restDay
        );

        return boardResponseDto;
    }
    List<BoardResponseDto> boardsToBoardResponseDtos(List<Board> boards);
}
