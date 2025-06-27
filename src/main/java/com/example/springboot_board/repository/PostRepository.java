package com.example.springboot_board.repository;

import com.example.springboot_board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// Post 엔티티에 대해 DB 접근을 가능하게 해주는 인터페이스
// JpaRepository<Post, Long> 을 상속받으면 CRUD 기능을 기본적으로 제공함
public interface PostRepository extends JpaRepository<Post, Long> {
    // 별도 메서드 없이도 기본적인 저장(save), 조회(findById, findAll), 삭제(delete) 가능
}