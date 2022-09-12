package com.mainframe.mainframe.board.repository;

import com.mainframe.mainframe.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findById(long boardId);
}
