package com.example.springboot_board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // get,set 메소드를 자동으로 만들어주는 어노테이션
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
}
