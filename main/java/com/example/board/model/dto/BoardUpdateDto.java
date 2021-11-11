package com.example.board.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateDto {
    private String identity;
    private Long board_id;
    private String title;
    private String content;
}
