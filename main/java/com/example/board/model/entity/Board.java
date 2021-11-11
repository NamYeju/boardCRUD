package com.example.board.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
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

    //연관관계 설정
    public void setMember(Member member){
        this.member = member;
    }

    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void updateBoard (String content){
        this.content = content;
    }
}
