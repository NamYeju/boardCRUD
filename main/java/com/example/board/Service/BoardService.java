package com.example.board.Service;

import com.example.board.model.dto.BoardCreateDto;
import com.example.board.model.dto.BoardSearchAllDto;
import com.example.board.model.dto.BoardSearchDetailDto;
import com.example.board.model.dto.BoardUpdateDto;
import com.example.board.model.entity.Board;
import com.example.board.model.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    MemberRepository memberRepository;

    //게시판 작성
    public void createBoard(BoardCreateDto boardCreateDto){
        Member member = memberRepository.findByIdentity(boardCreateDto.getIdentity());
        if(member == null)
            return;
        Board board = new Board(boardCreateDto.getTitle(), boardCreateDto.getContent(), member);
        boardRepository.save(board);
    }

    //게시판 수정
    public void updateBoard(BoardUpdateDto boardUpdateDto){
        Member member = memberRepository.findByIdentity(boardUpdateDto.getIdentity());
        Optional<Board> board = boardRepository.findById(boardUpdateDto.getBoard_id());
        if(member.getIdentity() == board.get().getMember().getIdentity()) {
            board.get().updateBoard(boardUpdateDto.getContent());
            boardRepository.save(board.get());
        }
        else return;
    }

    //게시판 삭제
    public void deleteBoard(String title){
        Board board = boardRepository.findByTitle(title);
        boardRepository.delete(board);
    }
    
    //게시판 전체 조회
    public List<BoardSearchAllDto> searchAllBoard(){
        List<BoardSearchAllDto> boardSearchAllDto = new ArrayList<>();
        List<Board> board = boardRepository.findAll();

        for(int i=4; i<board.size(); i++){
            BoardSearchAllDto boardSearchAllDto1 = new BoardSearchAllDto();
            String identity = board.get(i).getMember().getIdentity();
            String title = board.get(i).getTitle();
            boardSearchAllDto1.setIdentity(identity);
            boardSearchAllDto1.setTitle(title);
            boardSearchAllDto.add(boardSearchAllDto1);
        }
        return boardSearchAllDto;
    }
    //게시판 상세 조회
    public BoardSearchDetailDto searchDetailBoard(Long board_id){
        BoardSearchDetailDto boardSearchDetailDto = new BoardSearchDetailDto();
        Optional<Board> board = boardRepository.findById(board_id);

        boardSearchDetailDto.setBoard_id(board_id);
        boardSearchDetailDto.setIdentity(board.get().getMember().getIdentity());
        boardSearchDetailDto.setTitle(board.get().getTitle());
        boardSearchDetailDto.setContent(board.get().getContent());

        return boardSearchDetailDto;
    }


}
