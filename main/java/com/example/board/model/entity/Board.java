package com.example.board.model.entity;

import com.example.board.model.dto.BoardSearchAllDto;
import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Entity
@Builder
@AllArgsConstructor
public class Board {
    @Id
    @Column(name = "BOARD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    //연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public Board() {

    }


    //연관관계 설정
    public void setMember(Member member){
        this.member = member;
    }

    public void updateBoard (String content){
        this.content = content;
    }

    public BoardSearchAllDto toDomain(){
        return BoardSearchAllDto.builder()
                .identity(this.member.getIdentity())
                .title(this.title)
                .build();
    }
}
