package com.example.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class BoardCreateDto {
    private String identity;
    private String title;
    private String content;
}
