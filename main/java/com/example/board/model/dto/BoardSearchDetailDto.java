package com.example.board.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSearchDetailDto {
    private Long board_id;
    private String identity;
    private String title;
    private String content;
}
