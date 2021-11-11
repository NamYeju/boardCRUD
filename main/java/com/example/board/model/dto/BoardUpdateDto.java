package com.example.board.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateDto {
    private String identity;
    private String title;
    private String content;
}
