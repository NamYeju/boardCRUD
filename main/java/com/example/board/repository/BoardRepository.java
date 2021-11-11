package com.example.board.repository;

import com.example.board.model.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByMemberIdentity(String identity);
    Board findByTitle(String title);
}
