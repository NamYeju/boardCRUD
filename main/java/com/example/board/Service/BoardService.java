package com.example.board.Service;

import com.example.board.model.dto.BoardCreateDto;
import com.example.board.model.dto.BoardSearchAllDto;
import com.example.board.model.dto.BoardSearchDetailDto;
import com.example.board.model.dto.BoardUpdateDto;
import com.example.board.model.entity.Board;
import com.example.board.model.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;
import org.hibernate.query.spi.StreamDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Board board = Board.builder()
                .title(boardCreateDto.getTitle())
                .content(boardCreateDto.getContent())
                .member(member)
                .build();
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
    public void deleteBoard(Long board_id, String identity){
        Member member = memberRepository.findByIdentity(identity);
        Optional<Board> board = boardRepository.findById(board_id);
        if(board.get().getMember().getIdentity() == member.getIdentity())
            boardRepository.delete(board.get());
        else return;
    }
    
    //게시판 전체 조회
    public List<BoardSearchAllDto> searchAllBoard2(){
        List<BoardSearchAllDto> boardSearchAllDto = new ArrayList<>();

        List<String> identityList = boardRepository.findAll()
                .stream()
                .map(Board::getMember)
                .map(Member::getIdentity)
                .collect(Collectors.toList());

        List<String> titleList = boardRepository.findAll()
                .stream()
                .map(Board::getTitle)
                .collect(Collectors.toList());

        for(int i=1; i< identityList.size(); i++){
            boardSearchAllDto.get(i).setIdentity(identityList.get(i));
            boardSearchAllDto.get(i).setTitle(titleList.get(i));
        }

        return boardSearchAllDto;
    }
    public List<BoardSearchAllDto> searchAllBoard(){
        List<Board> boardList = boardRepository.findAll();
//        return boardList.stream()
//                .map(board -> {
//                    return new BoardSearchAllDto(board.getMember().getIdentity(), board.getTitle());
//                })
//                .collect(Collectors.toList());
        return boardList.stream()
                .map(board -> board.toDomain()) //Board::toDomain
                .collect(Collectors.toList());

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
