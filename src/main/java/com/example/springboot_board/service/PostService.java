package com.example.springboot_board.service;

import com.example.springboot_board.domain.Post;
import com.example.springboot_board.dto.PostRequestDto;
import com.example.springboot_board.dto.PostResponseDto;
import com.example.springboot_board.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service  // 이 클래스가 서비스임을 스프링에게 알림
@RequiredArgsConstructor  // 생성자 자동 주입 (final 붙은 필드만)
public class PostService {

    private final PostRepository postRepository;

    // 게시글 저장
    public void savePost(PostRequestDto requestDto) {
        Post post = new Post( // dto에서 게시글의 정보를 꺼낸 뒤 post 객체 생성 후 값 넘겨주기
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getAuthor(),
                requestDto.getPassword()
        );
        postRepository.save(post); // 넘겨 받은 값을 레포지토리에 저장
    }

    // 게시글 조회
    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found"));
        return new PostResponseDto(post);

    }

    // 게시글 전체 조회
    public List<PostResponseDto> getPostList() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostResponseDto::new).collect(Collectors.toList()); //post -> dto로 변환
    }

    // 게시글 수정
    @Transactional
    public void updatePost(Long id, PostRequestDto requestDto,String password) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found"));
        if(!password.equals(post.getPassword())) {
            throw new IllegalArgumentException("Wrong password");
        }
        post.update(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getAuthor()
        );

    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long id,String password) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found"));
        if(!password.equals(post.getPassword())) {
            throw new IllegalArgumentException("Wrong password");
        }
        postRepository.delete(post);
    }

}