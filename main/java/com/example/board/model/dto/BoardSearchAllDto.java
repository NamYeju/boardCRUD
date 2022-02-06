package com.example.board.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSearchAllDto {
    private String identity;
    private String title;

    @Builder
    public BoardSearchAllDto(String identity, String title) {
        this.identity = identity;
        this.title = title;
    }
}
