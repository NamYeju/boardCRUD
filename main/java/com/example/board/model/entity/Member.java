package com.example.board.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "board_member")
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String identity;

    private String password;
    private String name;
    private int age;

    public Member(String identity, String password, String name, int age) {
        this.identity = identity;
        this.password = password;
        this.name = name;
        this.age = age;
    }
    public void update(String name){
        this.name = name;
    }
}
