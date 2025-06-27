package com.example.springboot_board.service;

import com.example.springboot_board.domain.Post;
import com.example.springboot_board.dto.PostRequestDto;
import com.example.springboot_board.dto.PostResponseDto;
import com.example.springboot_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // 이 클래스가 서비스임을 스프링에게 알림
@RequiredArgsConstructor  // 생성자 자동 주입 (final 붙은 필드만)
public class PostService {

    private final PostRepository postRepository;

    // 게시글 저장
    public void savePost(PostRequestDto requestDto) {
        Post post = new Post( // dto에서 게시글의 정보를 꺼낸 뒤 post 객체 생성 후 값 넘겨주기
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getAuthor()
        );
        postRepository.save(post); // 넘겨 받은 값을 레포지토리에 저장
    }

    // 게시글 조회
    public PostResponseDto getPost(Long id) {

    }

    // 게시글 전체 조회
    public List<PostResponseDto> getPostList() {
        // 구현
    }

    // 게시글 수정
    public void updatePost(Long id, PostRequestDto requestDto) {
        // 구현
    }

    // 게시글 삭제
    public void deletePost(Long id) {
        // 구현
    }

}