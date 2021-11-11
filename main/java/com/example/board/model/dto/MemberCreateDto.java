package com.example.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberCreateDto {
    private String identity;
    private String password;
    private String name;
    private int age;
}
