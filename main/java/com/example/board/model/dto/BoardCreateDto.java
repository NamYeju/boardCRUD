package com.example.board.model.dto;

import com.example.board.model.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BoardCreateDto {
    private String identity;
    private String title;
    private String content;
}
