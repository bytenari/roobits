package com.mainframe.mainframe.board.service;

import com.mainframe.mainframe.board.entity.Board;
import com.mainframe.mainframe.board.repository.BoardRepository;
import org.hibernate.type.ListType;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) { this.boardRepository = boardRepository; }

    public Board createBoard(Board board) {
        String boardName = new String();
        board.setBoardName(boardName);

        return boardRepository.save(board);
    }

    public Board updateBoard(Board board) {
        Board findBoard = findBoard(board.getBoardId());

        Optional.ofNullable(board.getBoardName())
                .ifPresent(boardName -> findBoard.setBoardName(boardName));
        Optional.ofNullable(board.getBoardTheme())
                .ifPresent(boardTheme -> findBoard.setBoardTheme(boardTheme));

        return boardRepository.save(findBoard);
    }

    private Board findBoard(long boardId) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        Board findBoard = optionalBoard.orElseThrow();

        return findBoard;
    }

    private List<Board> findBoards(Board boards) {
        return boardRepository.findAll(List.of(Sort.by(boardId).descending()));
    }

    public void deleteBoard(long boardId) {
        Board board = findBoard(boardId);
        boardRepository.delete(board);
    }
}
