package com.example.springboot_board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity //이 클래스가 테이블임을 명시
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id //기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 초기화 값 설정
     private Long id;
    @Column(nullable = false, length = 100) //제약조건 NUll금지,길이 제한
     private String title;
     private String content;
     private String author;
    @CreatedDate //insert 시 자동 생성
     private LocalDateTime created_at;
    @LastModifiedDate //업데이트 시 자동 갱신
     private LocalDateTime  updated_at;
    // 생성자 추가
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    // update 메서드도 있으면 좋음
    public void update(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // JPA를 위한 기본 생성자
    protected Post() {}
}
