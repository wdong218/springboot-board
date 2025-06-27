package com.example.springboot_board.dto;

import com.example.springboot_board.domain.Post;
import lombok.Getter;

@Getter // 모든 필드에 대한 getter 메서드 자동 생성 (Lombok 제공)
public class PostResponseDto {

    // 응답에 포함될 필드들 (불변성 유지 위해 final로 선언)
    private final Long id;         // 게시글 ID
    private final String title;    // 게시글 제목
    private final String content;  // 게시글 본문
    private final String author;   // 게시글 작성자

    // Entity(Post)를 받아서 DTO로 변환하는 생성자
    public PostResponseDto(Post post) {
        this.id = post.getId();         // Post 엔티티의 ID를 받아서 저장
        this.title = post.getTitle();   // Post 엔티티의 제목을 받아서 저장
        this.content = post.getContent(); // Post 엔티티의 본문을 받아서 저장
        this.author = post.getAuthor();   // Post 엔티티의 작성자를 받아서 저장
    }
}