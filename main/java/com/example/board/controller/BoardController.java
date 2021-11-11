package com.example.board.controller;

import com.example.board.Service.BoardService;
import com.example.board.model.dto.BoardCreateDto;
import com.example.board.model.dto.BoardSearchAllDto;
import com.example.board.model.dto.BoardSearchDetailDto;
import com.example.board.model.dto.BoardUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    BoardService boardService;

    //생성
    @PostMapping("/createBoard")
    public void createBoard(@RequestBody  BoardCreateDto boardCreateDto){
        boardService.createBoard(boardCreateDto);
    }

    //수정
    @PutMapping("/updateBoard")
    public void updateBoard(@RequestBody BoardUpdateDto boardUpdateDto){
        boardService.updateBoard(boardUpdateDto);
    }
    //삭제
    @DeleteMapping("/deleteBoard")
    public void deleteBoard(@RequestParam String title){
        boardService.deleteBoard(title);
    }

    //전체 조회
    @GetMapping("/searchAllBoard")
    public List<BoardSearchAllDto> searchAllBoard(){
        return boardService.searchAllBoard();
    }
    //상세 조회
    @GetMapping("/searchDetailBoard")
    public BoardSearchDetailDto searchDetailBoard(@RequestParam Long board_id){
        return boardService.searchDetailBoard(board_id);
    }
}
